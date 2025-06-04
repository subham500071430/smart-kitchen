package com.example.demo;

import com.example.demo.dto.UserLoginRequest;
import com.example.demo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper {

    @Autowired
    public ModelMapper modelMapper;

    public UserLoginRequest mapUsertoDTO(User user){

        UserLoginRequest userDTO = modelMapper.map(user, UserLoginRequest.class);

        return userDTO;
    }

    public User mapToUser(UserLoginRequest userDTO){

         User user = modelMapper.map(userDTO,User.class);
         return user;
    }

}

