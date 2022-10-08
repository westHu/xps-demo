package com.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;

@Slf4j
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();



    public static String objectToString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("json objectToString exception:", e);
            return null;
        }
    }

    public static String objectToStringEx(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T stringToObject(String json,Class<T> object) throws IOException {
        return objectMapper.readValue(json,object);
    }

}
