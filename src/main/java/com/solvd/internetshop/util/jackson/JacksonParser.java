package com.solvd.internetshop.util.jackson;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;

import static com.solvd.internetshop.logger.MyLogger.myLogger;

public class JacksonParser {

    private static ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }


    public static JsonNode createJsonNode(File file) {
        try {
            return objectMapper().readTree(file);
        } catch (IOException e) {
            myLogger().error(e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T jsonNodeToObject(JsonNode node, Class<T> clazz) {
        try {
            return objectMapper().treeToValue(node, clazz);
        } catch (JsonProcessingException e) {
            myLogger().error(e);
            throw new RuntimeException(e);
        }
    }

    public static void objectToJsonFile(Object obj, String fileName) {
        try {
            objectMapper().writerWithDefaultPrettyPrinter()
                    .writeValue(new File(fileName), obj);
        } catch (IOException e) {
            myLogger().error(e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T createObjectFromJson(File file, Class<T> clazz) {
        try {
            return objectMapper().readValue(file, clazz);
        } catch (IOException e) {
            myLogger().error(e);
            throw new RuntimeException(e);
        }
    }

    public static String objectToStringJsonFormat(Object obj) {
        try {
            String jsonString = objectMapper()
                            .writerWithDefaultPrettyPrinter()
                            .writeValueAsString(obj);
            return jsonString;
        } catch (JsonProcessingException e) {
            myLogger().error(e);
            throw new RuntimeException(e);
        }
    }
}
