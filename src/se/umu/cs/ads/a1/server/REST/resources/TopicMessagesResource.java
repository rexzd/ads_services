package se.umu.cs.ads.a1.server.REST.resources;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.MessageId;
import se.umu.cs.ads.a1.types.Topic;

public class TopicMessagesResource extends ServerResource {
    private static final Messenger messenger = BackendLocator.getMessenger();
    private final ObjectMapper mapper = ObjectMapperFactory.get();

    @Get("json")
    public StringRepresentation getTopicMessages() throws Exception {
        String topicString = getAttribute("topic");
        topicString = URLDecoder.decode(topicString, StandardCharsets.UTF_8);
        if (!topicString.startsWith("/")) {
            topicString = "/" + topicString;
        }
        Topic topic = new Topic(topicString);
        MessageId[] messageIds = messenger.listMessages(topic);
        String json = mapper.writeValueAsString(messageIds);
        return new StringRepresentation(json, org.restlet.data.MediaType.APPLICATION_JSON);
    }
}
