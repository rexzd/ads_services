package se.umu.cs.ads.a1.server.REST.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import se.umu.cs.ads.a1.types.Content;

public class ContentJson {
    public static class Serializer extends JsonSerializer<Content> {
        @Override
        public void serialize(Content value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<Content> {
        @Override
        public Content deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new Content(p.getValueAsString());
        }
    }
}
