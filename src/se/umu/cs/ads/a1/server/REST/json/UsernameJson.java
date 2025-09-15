package se.umu.cs.ads.a1.server.REST.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

import se.umu.cs.ads.a1.types.Username;

public class UsernameJson {
    public static class Serializer extends JsonSerializer<Username> {
        @Override
        public void serialize(Username value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<Username> {
        @Override
        public Username deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new Username(p.getValueAsString());
        }
    }
}