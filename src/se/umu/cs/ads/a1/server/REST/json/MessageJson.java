package se.umu.cs.ads.a1.server.REST.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import se.umu.cs.ads.a1.types.Content;
import se.umu.cs.ads.a1.types.Data;
import se.umu.cs.ads.a1.types.Message;
import se.umu.cs.ads.a1.types.MessageId;
import se.umu.cs.ads.a1.types.Timestamp;
import se.umu.cs.ads.a1.types.Topic;
import se.umu.cs.ads.a1.types.Username;

public class MessageJson {
    public static class Deserializer extends JsonDeserializer<Message> {
        @Override
        public Message deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonNode node = p.getCodec().readTree(p);
            MessageId id = new MessageId(node.get("id").asText());
            Timestamp timestamp = new Timestamp(node.get("timestamp").asLong());
            Username username = new Username(node.get("username").asText());
            Topic topic = new Topic(node.get("topic").asText());
            Content content = new Content(node.get("content").asText());
            Data data = new Data(node.get("data").asText().getBytes());
            return new Message(id, timestamp, username, topic, content, data);
        }
    }
}
