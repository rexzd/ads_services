package se.umu.cs.ads.a1.server.REST.resources;

import org.restlet.resource.ServerResource;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.Get;
import org.restlet.resource.Delete;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.Message;
import se.umu.cs.ads.a1.types.MessageId;
import se.umu.cs.ads.a1.types.Username;
import se.umu.cs.ads.a1.types.Topic;
import se.umu.cs.ads.a1.types.Content;
import se.umu.cs.ads.a1.types.Data;

public class MessageBatchResource extends ServerResource{
    private static final Messenger messenger = BackendLocator.getMessenger();
    private static final ObjectMapper mapper = ObjectMapperFactory.get();

    @Post("json")
    public StringRepresentation storeMessages(Representation entity) throws Exception {
        String body = entity.getText();
        JsonNode root = mapper.readTree(body);
        Message[] messages = new Message[root.size()];
        for (int i = 0; i < root.size(); i++) {
            JsonNode node = root.get(i);
            Username username = new Username(node.get("username").asText());
            Topic topic = new Topic(node.get("topic").asText());
            Content content = new Content(node.get("content").asText());
            Data data = new Data(node.get("data").asText().getBytes());
            messages[i] = Message.construct(username, topic, content, data);
        }
        messenger.store(messages);
        String json = mapper.writeValueAsString(messages);
        return new StringRepresentation(json, MediaType.APPLICATION_JSON);
    }

    @Delete
    public void deleteMessage(Representation entity) throws Exception{
        String body = entity.getText();
        JsonNode node = mapper.readTree(body);
        MessageId[] messageIds;
        if (node.isArray()) {
            messageIds = new MessageId[node.size()];
            for (int i = 0; i < node.size(); i++) {
                messageIds[i] = new MessageId(node.get(i).asText());
            }
        } else {
            messageIds = new MessageId[0];
        }
        messenger.delete(messageIds);
    }

}
