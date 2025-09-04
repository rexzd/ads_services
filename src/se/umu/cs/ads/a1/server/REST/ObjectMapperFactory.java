package se.umu.cs.ads.a1.server.REST;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class ObjectMapperFactory {
    private static final ObjectMapper mapper = new ObjectMapper();
    private ObjectMapperFactory() {}

    public static ObjectMapper get() {
        return mapper;
    }
}
