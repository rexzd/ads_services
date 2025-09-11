package se.umu.cs.ads.a1.server.REST.resources;

import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Delete;
import org.restlet.resource.ServerResource;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.MessageId;
import se.umu.cs.ads.a1.types.Message;

public class MessageResource extends ServerResource{
    private static final Messenger messenger = BackendLocator.getMessenger();

    @Get("json")
    public StringRepresentation getMessage() throws Exception {
        String idString = getAttribute("id");
        MessageId messageId = new MessageId(idString);
        Message message = messenger.retrieve(messageId);
        String json = ObjectMapperFactory.get().writeValueAsString(message);
        return new StringRepresentation(json);
    }

    @Delete
    public void deleteMessage() {
        String idString = getAttribute("id");
        MessageId messageId = new MessageId(idString);
        messenger.delete(messageId);
    }
}
