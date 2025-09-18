package se.umu.cs.ads.a1.server.REST.resources;

import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.Username;

/**
 * REST resource for the global collection of users.
 * Supports listing all users in the system using GET.
 */
public class UsersResource extends ServerResource {
    private static final Messenger messenger = BackendLocator.getMessenger();
    private final ObjectMapper mapper = ObjectMapperFactory.get();

    @Get("json")
    public StringRepresentation getUsers() throws Exception {
        Username[] users = messenger.listUsers();
        String json = mapper.writeValueAsString(users);
        return new StringRepresentation(json);
    }
}
