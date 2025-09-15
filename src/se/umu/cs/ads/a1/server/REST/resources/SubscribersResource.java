package se.umu.cs.ads.a1.server.REST.resources;

import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.Topic;
import se.umu.cs.ads.a1.types.Username;

public class SubscribersResource extends ServerResource {
    private static final Messenger messenger = BackendLocator.getMessenger();
    private final ObjectMapper mapper = ObjectMapperFactory.get();

    @Get("json")
    public StringRepresentation getSubscribers() throws Exception {
        String topicString = getAttribute("topic");
        if (!topicString.startsWith("/")) {
            topicString = "/" + topicString;
        }
        Topic topic = new Topic(topicString);
        Username[] subscribers = messenger.listSubscribers(topic);
        String json = mapper.writeValueAsString(subscribers);
        return new StringRepresentation(json, org.restlet.data.MediaType.APPLICATION_JSON);
    }
}
