package com.myapp.service.service;

import com.myapp.service.dto.LoginRequest;
import com.myapp.service.dto.LoginResponse;
import com.myapp.service.dto.SignUpRequest;
import com.myapp.service.dto.SignUpResponse;
import com.myapp.service.entity.User;
import com.myapp.service.mapper.UserMapper;
import com.myapp.service.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
           User user = userMapper.toNewUser(request);
           Optional<User> foundUser = usersRepository.findById(user.getEmailId());

           if(foundUser.isPresent()){
               return new SignUpResponse("User Already Exists");
           } else{
               usersRepository.save(user);
               return new SignUpResponse("Registered New User");
           }
    }
}
