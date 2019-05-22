package com.pavesid.objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyDB {
    private String userName;// = "root"; //"1"
    private String userPassword;//= "1111";
    private String connectionURL;// = "jdbc:mysql://localhost:3306/mymap?useUnicode=true&serverTimezone=UTC";//Важно юзать то, что после ?. Иначе будет ошибка.

    public MyDB() {
//        this.userName = "root";
//        this.userPassword = "1111";
//        this.connectionURL = "jdbc:mysql://localhost:3306/mymap?useUnicode=true&serverTimezone=UTC";
        userName = "sql7291253";
        userPassword = "";
        connectionURL = "jdbc:mysql://db4free.net:3306/sql7291253";
    }

    public MyDB(String userPassword) {
        this.userName = "sql7291253";
        this.userPassword = userPassword;
        this.connectionURL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7291253";
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
        setUserPassword(userPassword);
        System.out.println(userPassword);
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, userPassword);
             Statement statement = connection.createStatement()) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    }