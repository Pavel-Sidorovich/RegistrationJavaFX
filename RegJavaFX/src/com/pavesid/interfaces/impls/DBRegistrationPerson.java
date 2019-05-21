package com.pavesid.interfaces.impls;

import com.pavesid.Main;
import com.pavesid.interfaces.RegistrationBook;
import com.pavesid.objects.Person;
import com.pavesid.objects.MyDB;

import java.sql.*;

public class DBRegistrationPerson implements RegistrationBook {

    @Override
    public void addPerson(Person person) {
        try {
            MyDB db = Main.getMyDB();
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(db.getConnectionURL(), db.getUserName(), db.getUserPassword());
                 Statement statement = connection.createStatement()) {
                //statement.executeUpdate(" create table mapDB (email varchar(50) NOT NULL,password varchar(15) NOT NULL,PRIMARY KEY (email));");
                statement.executeUpdate("INSERT into mapdb values ('" + person.getEmail() + "','" + person.getPassword() + "');");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void removePerson(Person person) {

    }

    @Override
    public boolean isPerson(Person person) {
        try {
            MyDB db = Main.getMyDB();
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(db.getConnectionURL(), db.getUserName(), db.getUserPassword());
                 Statement statement = connection.createStatement()) {
                //System.out.println("Ok");
                //statement.executeUpdate(" create table mapDB (email varchar(50) NOT NULL,password varchar(15) NOT NULL,PRIMARY KEY (email));");
                ResultSet resultSet = statement.executeQuery("SELECT * FROM mapdb WHERE email='" + person.getEmail() + "';");
                return resultSet.next();
            } catch (SQLException e) {
                //System.out.println("Bad");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Person getPerson(String email) {
        try {
            MyDB db = Main.getMyDB();
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(db.getConnectionURL(), db.getUserName(), db.getUserPassword());
                 Statement statement = connection.createStatement()) {
                //statement.executeUpdate(" create table mapDB (email varchar(50) NOT NULL,password varchar(15) NOT NULL,PRIMARY KEY (email));");
                //System.out.println("Подключил");
                ResultSet resultSet = statement.executeQuery("SELECT * FROM mapdb WHERE email='" + email + "';");

                System.out.println(resultSet.next());
//            while (resultSet.next()) {
//                return resultSet.getString(2);
//            }
            } catch (SQLException e) {
                //System.out.println("Облом");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Person("", "", "");
    }

    public Boolean isDeffPass(Person p) {
        //Person p = getPerson(email);
        if (!p.getDeffPass().equals("") && !p.getEmail().equals(""))
            return true;
        else return false;
    }
}
