package com.myapp.service.config;

import com.myapp.service.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    public UserMapper userMapper() {
           UserMapper userMapper = new UserMapper();
           return userMapper;
    }
}
