package com.solvd.internetshop.util.jaxb;

import com.solvd.internetshop.model.Address;
import com.solvd.internetshop.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JaxBMarshall {

        public static <T> void marshall(T t) {

            try {

                Marshaller marshaller = JAXBContext.newInstance(t.getClass()).createMarshaller();
                FileOutputStream file = new FileOutputStream("userMarshaller.xml");

                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(t, file);
                marshaller.marshal(t, System.out);
            } catch (JAXBException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }
}
