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

public class MessageBatchResource extends ServerResource{
    private static final Messenger messenger = BackendLocator.getMessenger();
    private static final ObjectMapper mapper = ObjectMapperFactory.get();

    @Post("json")
    public StringRepresentation storeMessages(Representation entity) throws Exception {
        String body = entity.getText();
        Message[] messages = mapper.readValue(body, Message[].class);
        messenger.store(messages);
        String json = mapper.writeValueAsString(messages);
        return new StringRepresentation(json, MediaType.APPLICATION_JSON);
    }

    @Get("json")
    public StringRepresentation retrieveMessages(Representation entity) throws Exception {
        String body = entity.getText();
        JsonNode node = mapper.readTree(body);
        MessageId[] messageIds = new MessageId[node.get("ids").size()];
        for (int i = 0; i < messageIds.length; i++) {
            messageIds[i] = new MessageId(node.get("ids").get(i).asText());
        }
        Message[] messages = messenger.retrieve(messageIds);
        String json = mapper.writeValueAsString(messages);
        return new StringRepresentation(json);
    }

    @Delete
    public void deleteMessage(Representation entity) throws Exception{
        String body = entity.getText();
        JsonNode node = mapper.readTree(body);
        MessageId[] messageIds = new MessageId[node.get("ids").size()];
        for (int i = 0; i < messageIds.length; i++) {
            messageIds[i] = new MessageId(node.get("ids").get(i).asText());
        }
        messenger.delete(messageIds);
    }

}
