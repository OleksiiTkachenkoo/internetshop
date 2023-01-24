package com.solvd.internetshop.connection;


import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.solvd.internetshop.properties.PropertiesUtil.*;


public class DbConnection {

    private static Connection connection;

    public DbConnection() {}

    private static BasicDataSource ds = new BasicDataSource();

    static {
        loadProperties();
        ds.setUrl(getURL());
        ds.setUsername(getUserName());
        ds.setPassword(getPASSWORD());
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getApacheDbConnection()  {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Connection getDbConnection() {

        try {
            if (connection != null) {
                return connection;
            }

            connection = DriverManager.getConnection(getURL(), getUserName(), getPASSWORD());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
  }


    public static void main(String[] args) {

    }

}




