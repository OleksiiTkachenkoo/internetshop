package com.solvd.internetshop.dao.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

import static com.solvd.internetshop.logger.MyLogger.myLogger;

public class MyBatisUtil {
    private static SqlSessionFactory factory;

    private MyBatisUtil() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            myLogger().error(e);
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
        return factory;
    }
}