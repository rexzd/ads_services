package se.umu.cs.ads.a1.server.REST.resources;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.databind.JsonNode;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;

import se.umu.cs.ads.a1.types.Username;
import se.umu.cs.ads.a1.types.Topic;

public class SubscriptionsResource extends ServerResource {
    private static final Messenger messenger = BackendLocator.getMessenger();

    @Post("json")
    public StringRepresentation subscribe(Representation entity) throws Exception {
        String body = entity.getText();
        JsonNode node = ObjectMapperFactory.get().readTree(body);
        Username username = new Username(node.get("username").asText());
        Topic topic = new Topic(node.get("topic").asText());
        Topic[] topics = messenger.subscribe(username, topic);
        String json = ObjectMapperFactory.get().writeValueAsString(topics);
        return new StringRepresentation(json);
    }

    @Delete("json")
    public StringRepresentation unsubscribe(Representation entity) throws Exception {
        String body = entity.getText();
        JsonNode node = ObjectMapperFactory.get().readTree(body);
        Username username = new Username(node.get("username").asText());
        Topic topic = new Topic(node.get("topic").asText());
        Topic[] topics = messenger.unsubscribe(username, topic);
        String json = ObjectMapperFactory.get().writeValueAsString(topics);
        return new StringRepresentation(json);
    }
}
