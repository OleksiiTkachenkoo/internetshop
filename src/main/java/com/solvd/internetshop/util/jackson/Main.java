package com.solvd.internetshop.util.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.solvd.internetshop.model.Address;
import com.solvd.internetshop.model.User;

import java.io.File;

import static com.solvd.internetshop.util.jackson.JacksonParser.*;

public class Main {
    public static void main(String[] args) {

        File userJsonFile = new File("./src/main/java/com/solvd" +
                                            "/internetshop/util/jackson/json/user.json");

        User user = new User(1, "Alex", "Yo",
                "+380934987349", "okefkewe324", "so3@gmail.com", 23,
                new Address(1, "Ukraine", "Kyiv", "Kyrilenko 23", "27", 1, 2));

        System.out.println(objectToStringJsonFormat(user));

        JsonNode node = createJsonNode(userJsonFile);
        System.out.println(node.get("firstName").asText());

        User user1 = createObjectFromJson(userJsonFile, User.class);
        System.out.println(user1.getAddress().getCountry());

        User user2 = jsonNodeToObject(node, User.class);
        System.out.println(user2);
        System.out.println(user2.getAddress().getCity());
        objectToJsonFile(user, "user1.json");
   }
}
