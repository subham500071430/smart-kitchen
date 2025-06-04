package com.example.demo.mapper;

import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

public class UserMapper {

    @Autowired
    public ModelMapper modelMapper;

    public LoginRequest toDto(User user) {
        LoginRequest dto = modelMapper.map(user, LoginRequest.class);
        return dto;
    }

    public User toUser(LoginRequest dto) {
        User user = modelMapper.map(dto, User.class);
        return user;
    }

}

