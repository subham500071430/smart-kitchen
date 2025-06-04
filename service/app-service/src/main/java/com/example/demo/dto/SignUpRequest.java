package com.example.demo.dto;

public class SignUpRequest {

    private final String email_id;
    private final String password;
    private final String name;

    public SignUpRequest(String email_id, String password, String name) {
        this.email_id = email_id;
        this.password = password;
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
