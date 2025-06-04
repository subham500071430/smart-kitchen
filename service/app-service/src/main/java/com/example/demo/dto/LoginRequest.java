package com.example.demo.dto;

public class LoginRequest {

    private final String email_id;
    private final String password;

    public LoginRequest(String email_id, String password) {
        this.email_id = email_id;
        this.password = password;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getPassword() {
        return password;
    }
}
