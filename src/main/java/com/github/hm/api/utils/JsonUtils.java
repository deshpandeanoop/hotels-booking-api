package com.github.hm.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public final class JsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtils() {

    }

    public static Optional<String> toJsonString(final Object object) {
        try {
            return Optional.of(objectMapper.writeValueAsString(object));
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while parsing bean, here is the message {}", exception.getMessage());
        }
        return Optional.empty();
    }
}