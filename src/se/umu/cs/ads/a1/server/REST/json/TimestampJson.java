package se.umu.cs.ads.a1.server.REST.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import se.umu.cs.ads.a1.types.Timestamp;

public class TimestampJson {
    public static class Serializer extends JsonSerializer<Timestamp> {
        @Override
        public void serialize(Timestamp value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(value.getValue());
        }
    }

    public static class Deserializer extends JsonDeserializer<Timestamp> {
        @Override
        public Timestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new Timestamp(p.getLongValue());
        }
    }
}
