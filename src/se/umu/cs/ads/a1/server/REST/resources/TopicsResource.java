package se.umu.cs.ads.a1.server.REST.resources;

import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.Topic;

/**
 * REST resource for operations on the global collection of topics.
 * Supports listing all topics in the system using GET.
 */
public class TopicsResource extends ServerResource {
    private static final Messenger messenger = BackendLocator.getMessenger();
    private final ObjectMapper mapper = ObjectMapperFactory.get();

    @Get("json")
    public StringRepresentation getAllTopics() throws Exception {
        Topic[] topics = messenger.listTopics();
        String json = mapper.writeValueAsString(topics);
        return new StringRepresentation(json, org.restlet.data.MediaType.APPLICATION_JSON);
    }
}
