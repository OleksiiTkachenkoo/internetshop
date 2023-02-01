package com.solvd.internetshop.util.jaxb;

import com.solvd.internetshop.model.Address;
import com.solvd.internetshop.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JaxBMarshall {
    public static void main(String[] args) {


        User user = new User(1, "Alex", "Yo",
                "+380934987349", "okefkewe324", "so3@gmail.com", 23,
                new Address(1, "Ukraine", "Kyiv", "Kyrilenko 23", "27", 1, 2));


            try {
                Marshaller marshaller = JAXBContext.newInstance(User.class).createMarshaller();

                FileOutputStream file = new FileOutputStream("userMarshaller.xml");
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(user, file);
                marshaller.marshal(user, System.out);
            } catch (JAXBException | FileNotFoundException e) {
                e.printStackTrace();
            }
    }
}
