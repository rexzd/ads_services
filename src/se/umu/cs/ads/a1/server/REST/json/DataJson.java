package se.umu.cs.ads.a1.server.REST.json;

import java.io.IOException;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import se.umu.cs.ads.a1.types.Data;

public class DataJson {
    public static class Serializer extends JsonSerializer<Data> {
        @Override
        public void serialize(Data value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(Base64.getEncoder().encodeToString(value.getValue()));
        }
    }

    public static class Deserializer extends JsonDeserializer<Data> {
        @Override
        public Data deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new Data(Base64.getDecoder().decode(p.getValueAsString()));
        }
    }
}
