package com.myapp.service.service;

import com.myapp.service.dto.LoginRequest;
import com.myapp.service.dto.LoginResponse;
import com.myapp.service.dto.SignUpRequest;
import com.myapp.service.dto.SignUpResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

       LoginResponse login(LoginRequest request);

       SignUpResponse signUp(SignUpRequest request);
}
