package com.myapp.service.controller;

import com.myapp.service.dto.*;
import com.myapp.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        JwtLoginResponse response = userService.login(loginRequest);

        if (Objects.nonNull(response.getToken())) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(new InvalidCredentialsResponse("Invalid username/password"));
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
