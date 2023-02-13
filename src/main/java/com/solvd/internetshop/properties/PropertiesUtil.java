package com.solvd.internetshop.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

import static com.solvd.internetshop.logger.MyLogger.myLogger;

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
            URL = p.getProperty("dBConnection.url");
            USER_NAME = p.getProperty("dBConnection.username");
            PASSWORD = p.getProperty("dBConnection.password");
        } catch (IOException e) {
            myLogger().error(e);
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
