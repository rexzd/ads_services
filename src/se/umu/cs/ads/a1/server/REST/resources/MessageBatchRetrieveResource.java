package se.umu.cs.ads.a1.server.REST.resources;

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.REST.ObjectMapperFactory;
import se.umu.cs.ads.a1.types.Message;
import se.umu.cs.ads.a1.types.MessageId;

/**
 * REST resource for retrieving multiple messages in one request.
 * Accepts a list of message IDs in the request body and returns
 * the corresponding messages.
 */
public class MessageBatchRetrieveResource extends ServerResource {
    private static final Messenger messenger = BackendLocator.getMessenger();
    private static final ObjectMapper mapper = ObjectMapperFactory.get();

    @Post("json")
    public StringRepresentation retrieveMessages(Representation entity) throws Exception {
        String body = entity.getText();
        JsonNode node = mapper.readTree(body);
        MessageId[] messageIds;

        if (node.isArray()) {
            messageIds = new MessageId[node.size()];
            for (int i = 0; i < node.size(); i++) {
                messageIds[i] = new MessageId(node.get(i).asText());
            }
        } else if (node.has("ids")) {
            JsonNode idsNode = node.get("ids");
            messageIds = new MessageId[idsNode.size()];
            for (int i = 0; i < idsNode.size(); i++) {
                messageIds[i] = new MessageId(idsNode.get(i).asText());
            }
        } else {
            throw new IllegalArgumentException("Invalid JSON format for batch retrieve: " + body);
        }

        Message[] messages = messenger.retrieve(messageIds);
        String json = mapper.writeValueAsString(messages);
        return new StringRepresentation(json, MediaType.APPLICATION_JSON);
    }
}
