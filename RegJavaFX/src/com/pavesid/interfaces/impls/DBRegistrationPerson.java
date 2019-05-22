package com.pavesid.interfaces.impls;

import com.pavesid.Main;
import com.pavesid.interfaces.RegistrationBook;
import com.pavesid.objects.Person;
import com.pavesid.objects.MyDB;

import java.sql.*;

public class DBRegistrationPerson implements RegistrationBook {

    MyDB db = Main.getMyDB();
    private void sqlQuery(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(db.getConnectionURL(), db.getUserName(), db.getUserPassword());
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPerson(Person person) {
        sqlQuery("INSERT into mapdb values ('" + person.getEmail() + "','" + person.getPassword() +"','" + person.getPassDefault() + "');");
    }

    @Override
    public void updateDefPassPerson(Person person) {
        //Создаем новый дефолт.
        sqlQuery("UPDATE mapdb SET passDefault = '" + person.getPassDefault() + "' WHERE email = '" + person.getEmail() + "';");
    }

    @Override
    public void updatePassPerson(String email, String password) {
        //Дефолт зануляем, вставляем необходимый новый.
        sqlQuery("UPDATE mapdb SET passDefault = 'NULL', password = '" + password +"' WHERE email = '" + email + "';");
    }

    @Override
    public void removePerson(Person person) {
        sqlQuery("DELETE FROM mapdb WHERE email = '" + person.getEmail() + "';");
    }

    @Override
    public boolean isPerson(Person person) {
        try {
            MyDB db = Main.getMyDB();
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(db.getConnectionURL(), db.getUserName(), db.getUserPassword());
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM mapdb WHERE email='" + person.getEmail() + "';");
                return resultSet.next();
            } catch (SQLException e) {
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
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(db.getConnectionURL(), db.getUserName(), db.getUserPassword());
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM mapdb WHERE email='" + email + "';");
            while (resultSet.next()) {
                return new Person(resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("passDefault"));
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Person("", "", "");
    }

    public Boolean isDefPass(Person p) {
        if (!p.getPassDefault().equals("") && !p.getEmail().equals(""))
            return true;
        else return false;
    }
}
