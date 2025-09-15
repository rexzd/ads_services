package se.umu.cs.ads.a1.server.REST.resources;

import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.MessageId;
import se.umu.cs.ads.a1.types.Username;

public class UserMessagesResource extends ServerResource{
    private static final Messenger messenger = BackendLocator.getMessenger();
    private final ObjectMapper mapper = ObjectMapperFactory.get();

    @Get("json")
    public StringRepresentation getUserMessages() throws Exception {
        String usernameString = getAttribute("username");
        try {
            Username username = new Username(usernameString);
            MessageId[] messageIds = messenger.listMessages(username);
            String json = mapper.writeValueAsString(messageIds);
            return new StringRepresentation(json, org.restlet.data.MediaType.APPLICATION_JSON);
        } catch (IllegalArgumentException e) {
            return new StringRepresentation("[]", org.restlet.data.MediaType.APPLICATION_JSON);
        }
    }
}
