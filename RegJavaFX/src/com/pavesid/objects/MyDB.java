package com.pavesid.objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyDB {
    private String userName;
    private String userPassword;
    private String connectionURL;

    public MyDB() {
        userName = "sql7291253";
        userPassword = "";
        connectionURL = "jdbc:mysql://db4free.net:3306/sql7291253";
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getConnectionURL() {
        return connectionURL;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isRightPass(String userPassword) {
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, userPassword);
             Statement statement = connection.createStatement()) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    }