package com.solvd.internetshop.util.jaxb;

import com.solvd.internetshop.model.Address;
import com.solvd.internetshop.model.User;

import static com.solvd.internetshop.util.jaxb.JaxBMarshall.marshall;
import static com.solvd.internetshop.util.jaxb.JaxBUnMarshall.unMarshall;

public class Main {
    public static void main(String[] args) {

        User user = new User();
        unMarshall(user);

        User user1 = new User(1, "Alex", "Yo",
                "+380934987349", "okefkewe324", "so3@gmail.com", 23,
                new Address(1, "Ukraine", "Kyiv", "Kyrilenko 23", "27", 1, 2));
        marshall(user1);
    }
}
