package com.olga.wikipedia.model;

public class User {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public User withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }
}
