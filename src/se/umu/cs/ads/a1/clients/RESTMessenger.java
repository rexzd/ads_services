package se.umu.cs.ads.a1.clients;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.Message;
import se.umu.cs.ads.a1.types.MessageId;
import se.umu.cs.ads.a1.types.Topic;
import se.umu.cs.ads.a1.types.Username;

public class RESTMessenger implements Messenger {
    private final String baseUrl;
    private final HttpClient client;
    private final ObjectMapper mapper;

    public RESTMessenger() {
        this("localhost", 8000);
    }

    public RESTMessenger(String host, int port) {
        this.baseUrl = "http://" + host + ":" + port;
        this.client = HttpClient.newHttpClient();
        this.mapper = ObjectMapperFactory.get();
    }

    @SuppressWarnings("unchecked")
    private <T> T get(String path, Class<T> c) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .GET()
            .build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        if (res.statusCode() >= 400) {
            // Treat errors as empty array/object depending on expected type
            if (c.isArray()) {
                return (T) java.lang.reflect.Array.newInstance(c.getComponentType(), 0);
            }
            return null;
        }
        return mapper.readValue(res.body(), c);
    }

    private <T> T post(String path, Object body, Class<T> c) throws Exception {
        String json = mapper.writeValueAsString(body);
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        if (c == Void.class || res.body().isEmpty()) {
            return null;
        }
        return mapper.readValue(res.body(), c);
    }

    private <T> T delete(String path, Object body, Class<T> c) throws Exception {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .header("Content-Type", "application/json");

        if (body == null) {
            builder.DELETE();
        } else {
            String json = mapper.writeValueAsString(body);
            builder.method("DELETE", HttpRequest.BodyPublishers.ofString(json));
        }

        HttpResponse<String> res = client.send(builder.build(), HttpResponse.BodyHandlers.ofString());

        if (c == Void.class || res.body().isEmpty()) {
            return null;
        }
        return mapper.readValue(res.body(), c);
    }

    @Override
    public void store(Message message) {
        try {
            post("/messages", message, Message.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void store(Message[] messages) {
        try {
            post("/messages/batch", messages, Message[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Message retrieve(MessageId message) {
        try {
            return get("/messages/" + message.getValue(), Message.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Message[] retrieve(MessageId[] messages) {
        try {
            return post("/messages/batch/retrieve", messages, Message[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(MessageId message) {
        try {
            delete("/messages/" + message.getValue(), null, Void.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(MessageId[] messages) {
        try {
            delete("/messages/batch", messages, Void.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic[] subscribe(Username username, Topic topic) {
        try {
            String json = String.format("{\"username\":\"%s\",\"topic\":\"%s\"}",
                username.getValue(), topic.getValue());
            return post("/subscriptions", mapper.readTree(json), Topic[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic[] unsubscribe(Username username, Topic topic) {
        try {
            String json = String.format("{\"username\":\"%s\",\"topic\":\"%s\"}",
                username.getValue(), topic.getValue());
            return delete("/subscriptions", mapper.readTree(json), Topic[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Username[] listUsers() {
        try {
            return get("/users", Username[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic[] listTopics() {
        try {
            return get("/topics", Topic[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic[] listTopics(Username username) {
        try {
            return get("/users/" + username.getValue() + "/topics", Topic[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Username[] listSubscribers(Topic topic) {
        try {
            String t = topic.getValue();
            if (t.startsWith("/")) t = t.substring(1);
            return get("/topics/" + t + "/subscribers", Username[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MessageId[] listMessages(Username username) {
        try {
            String[] ids = get("/users/" + username.getValue() + "/messages", String[].class);
            MessageId[] result = new MessageId[ids.length];
            for (int i = 0; i < ids.length; i++) {
                result[i] = new MessageId(ids[i]);
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MessageId[] listMessages(Topic topic) {
        try {
            String t = topic.getValue();
            if (t.startsWith("/")) t = t.substring(1);
            String encoded = URLEncoder.encode(t, StandardCharsets.UTF_8);
            String[] ids = get("/topics/" + encoded + "/messages", String[].class);
            MessageId[] result = new MessageId[ids.length];
            for (int i = 0; i < ids.length; i++) {
                result[i] = new MessageId(ids[i]);
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
