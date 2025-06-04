package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.dto.SignUpResponse;

public interface UserService {

    LoginResponse login(LoginRequest request);

    SignUpResponse signUp(SignUpRequest request);
}
