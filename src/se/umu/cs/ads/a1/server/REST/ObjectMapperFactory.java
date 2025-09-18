package se.umu.cs.ads.a1.server.REST;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import se.umu.cs.ads.a1.server.REST.json.ContentJson;
import se.umu.cs.ads.a1.server.REST.json.DataJson;
import se.umu.cs.ads.a1.server.REST.json.MessageIdJson;
import se.umu.cs.ads.a1.server.REST.json.MessageJson;
import se.umu.cs.ads.a1.server.REST.json.SubscriptionIdJson;
import se.umu.cs.ads.a1.server.REST.json.TimestampJson;
import se.umu.cs.ads.a1.server.REST.json.TopicJson;
import se.umu.cs.ads.a1.server.REST.json.UsernameJson;
import se.umu.cs.ads.a1.types.Content;
import se.umu.cs.ads.a1.types.Data;
import se.umu.cs.ads.a1.types.Message;
import se.umu.cs.ads.a1.types.MessageId;
import se.umu.cs.ads.a1.types.SubscriptionId;
import se.umu.cs.ads.a1.types.Timestamp;
import se.umu.cs.ads.a1.types.Topic;
import se.umu.cs.ads.a1.types.Username;

/**
 * Factory for a preconfigured Jackson ObjectMapper.
 * Registers custom serializers and deserializers for all types
 * to support JSON conversion in REST resources.
 */
public final class ObjectMapperFactory {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Username.class, new UsernameJson.Serializer());
        module.addDeserializer(Username.class, new UsernameJson.Deserializer());
        module.addSerializer(Topic.class, new TopicJson.Serializer());
        module.addDeserializer(Topic.class, new TopicJson.Deserializer());
        module.addSerializer(Content.class, new ContentJson.Serializer());
        module.addDeserializer(Content.class, new ContentJson.Deserializer());
        module.addSerializer(MessageId.class, new MessageIdJson.Serializer());
        module.addDeserializer(MessageId.class, new MessageIdJson.Deserializer());
        module.addSerializer(SubscriptionId.class, new SubscriptionIdJson.Serializer());
        module.addDeserializer(SubscriptionId.class, new SubscriptionIdJson.Deserializer());
        module.addSerializer(Timestamp.class, new TimestampJson.Serializer());
        module.addDeserializer(Timestamp.class, new TimestampJson.Deserializer());
        module.addSerializer(Data.class, new DataJson.Serializer());
        module.addDeserializer(Data.class, new DataJson.Deserializer());
        module.addDeserializer(Message.class, new MessageJson.Deserializer());
        mapper.registerModule(module);
    }

    public static ObjectMapper get() {
        return mapper;
    }
}
