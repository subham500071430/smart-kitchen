package com.myapp.service.controller;

import com.myapp.service.dto.LoginRequest;
import com.myapp.service.dto.LoginResponse;
import com.myapp.service.dto.SignUpRequest;
import com.myapp.service.dto.SignUpResponse;
import com.myapp.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        LoginResponse loginResponse = userService.login(loginRequest);

        if (loginResponse.isSuccess()) {
            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(401).body(loginResponse);
        }
    }

    @PostMapping(path = "/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SignUpResponse> signup(@RequestBody SignUpRequest signUpRequest) {

        SignUpResponse signUpResponse = userService.signUp(signUpRequest);

        if (signUpResponse.isSuccess()) {
            return ResponseEntity.ok(signUpResponse);
        } else {
            return ResponseEntity.status(401).body(signUpResponse);
        }
    }

    @GetMapping(path = "/hello")
    public String getHello() {
        return "Hello";
    }
}
