package com.solvd.internetshop.util.jaxb;

import com.solvd.internetshop.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class JaxBUnMarshall {

       private static File file = new File("src/main/java/com/solvd/internetshop/util/jaxb/xmlfile/jaxb.xml");

       public static void unMarshall() {
           try {
               Unmarshaller unmarshaller = JAXBContext.newInstance(User.class).createUnmarshaller();
               User user  = (User) unmarshaller.unmarshal(file);
               System.out.println(user.toString());
           } catch (JAXBException e) {
               e.printStackTrace();
           }
       }
}

