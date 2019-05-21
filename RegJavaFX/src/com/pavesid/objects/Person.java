package com.pavesid.objects;

public class Person {
    private String email;
    private String password;
    private String deffPass;

    public Person(String email, String phone, String deffPass) {
        this.email = email;
        this.password = password;
        this.deffPass = deffPass;
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

    public String getDeffPass() {
        return deffPass;
    }

    public void setDeffPass(String deffPass) {
        this.deffPass = deffPass;
    }
}
