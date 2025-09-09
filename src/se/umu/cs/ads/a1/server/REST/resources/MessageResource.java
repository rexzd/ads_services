package se.umu.cs.ads.a1.server.REST.resources;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.databind.JsonNode;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.Content;
import se.umu.cs.ads.a1.types.Topic;
import se.umu.cs.ads.a1.types.Username;
import se.umu.cs.ads.a1.types.Data;
import se.umu.cs.ads.a1.types.Message;

public class MessageResource extends ServerResource {
    private static final Messenger messenger = BackendLocator.getMessenger();

    @Post("json")
    public StringRepresentation storeMessage(Representation entity) throws Exception {
        String body = entity.getText();
        JsonNode node = ObjectMapperFactory.get().readTree(body);
        Username username = new Username(node.get("username").asText());
        Topic topic = new Topic(node.get("topic").asText());
        Content content = new Content(node.get("content").asText());
        Data data = new Data(node.get("data").asText().getBytes());
        Message message = Message.construct(username, topic, content, data);
        messenger.store(message);
        String json = ObjectMapperFactory.get().writeValueAsString(message);
        return new StringRepresentation(json);
    }

}
