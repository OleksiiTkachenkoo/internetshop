package com.solvd.internetshop.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

public class PropertiesUtil {

    private static String PASSWORD;
    private static String USER_NAME;
    private static String URL;

    private static Properties p = new Properties();


    public PropertiesUtil() {}



    public static void loadProperties() {
        try (FileInputStream f =
                     new FileInputStream("./src/main/resources/dBConnection.properties")) {
            p.load(f);
            URL = p.getProperty("db.url");
            USER_NAME = p.getProperty("db.user_name");
            PASSWORD = p.getProperty("db.password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getUserName() {
        return USER_NAME;
    }

    public static String getURL() {
        return URL;
    }
}
