package com.pavesid.objects;

public class Person {
    private String email;
    private String password;
    private String passDefault;

    public Person(String email, String password, String passDefault) {
        this.email = email;
        this.password = password;
        this.passDefault = passDefault;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassDefault() {
        return passDefault;
    }

    public void setPassDefault(String passDefault) {
        this.passDefault = passDefault;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", defPass='" + passDefault + '\'' +
                '}';
    }
}
