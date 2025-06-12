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

    @PostMapping(path = "/login", consumes = "application/json" , produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @PostMapping(path = "/signup")
    public SignUpResponse signup(@RequestBody SignUpRequest signUpRequest) {
        return userService.signUp(signUpRequest);
    }

    @GetMapping(path = "/hello")
    public String getHello() {
        return "Hello";
    }
}
