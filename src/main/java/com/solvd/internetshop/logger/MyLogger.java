package com.solvd.internetshop.logger;

import org.apache.logging.log4j.LogManager;



public class MyLogger {

    private static MyLogger logger;

    public MyLogger() {}

    public static synchronized MyLogger myLogger() {
        if (logger != null) {
            logger = (MyLogger) LogManager.getLogger();
        }
        return  logger;
    }

    public <T> void  error(T t) {
        System.out.println(t);
    }
}
