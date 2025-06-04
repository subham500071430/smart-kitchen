package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.dto.SignUpResponse;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userMapper.toUser(request);
        Optional<User> foundUser = usersRepository.findById(user.getEmailId());

        if (foundUser.isPresent()) {
            return new LoginResponse(user.getEmailId());
        } else {
            return new LoginResponse();
        }
    }


    @Override
    public SignUpResponse signUp(SignUpRequest request) {
           return null;
    }
}
