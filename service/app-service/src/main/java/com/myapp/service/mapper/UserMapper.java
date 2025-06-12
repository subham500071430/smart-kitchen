package com.myapp.service.mapper;

import com.myapp.service.dto.LoginRequest;
import com.myapp.service.dto.SignUpRequest;
import com.myapp.service.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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

    public User toNewUser(SignUpRequest dto){
           User user = modelMapper.map(dto, User.class);
           return user;
    }

}

