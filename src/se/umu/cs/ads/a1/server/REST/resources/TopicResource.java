package se.umu.cs.ads.a1.server.REST.resources;

import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.Username;
import se.umu.cs.ads.a1.types.Topic;

/**
 * REST resource for accessing topics subscribed to by a specific user.
 * Retrieves all topics for the given username using GET.
 */
public class TopicResource extends ServerResource {
    private static final Messenger messenger = BackendLocator.getMessenger();
    private final ObjectMapper mapper = ObjectMapperFactory.get();

    @Get("json")
    public StringRepresentation getTopics() throws Exception {
        String usernameString = getAttribute("username");
        Username username = new Username(usernameString);
        Topic[] topics = messenger.listTopics(username);
        String json = mapper.writeValueAsString(topics);
        return new StringRepresentation(json, org.restlet.data.MediaType.APPLICATION_JSON);
    }
}
