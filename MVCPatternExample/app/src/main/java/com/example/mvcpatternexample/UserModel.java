package com.example.mvcpatternexample;

public class UserModel {

    private String username;
    private String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkValidity() {
        return !this.username.isEmpty() && !this.password.isEmpty();
    }
}
