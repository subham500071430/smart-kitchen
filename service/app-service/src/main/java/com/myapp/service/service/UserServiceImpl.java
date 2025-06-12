package com.myapp.service.service;

import com.myapp.service.dto.*;
import com.myapp.service.entity.Role;
import com.myapp.service.entity.User;
import com.myapp.service.entity.UserRole;
import com.myapp.service.mapper.UserMapper;
import com.myapp.service.repository.UserRolesRepository;
import com.myapp.service.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserRolesRepository userRolesRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userMapper.toExistingUser(request);
        Optional<User> foundUser = usersRepository.findById(user.getEmailId());

        if (foundUser.isPresent()) {
            return new LoginResponse(user.getEmailId());
        } else {
            return new LoginResponse();
        }
    }


    @Override
    public SignUpResponse signUp(SignUpRequest request) {
           User user = userMapper.mapNewUser(request);
           UserRole userRole = new UserRole();
           userRole.setUser(user);
           userRole.setRole(Role.valueOf(request.getRole()));

           Optional<User> foundUser = usersRepository.findById(user.getEmailId());

           if(foundUser.isPresent()){
               return new SignUpResponse("User Already Exists");
           } else{
               usersRepository.save(user);
               userRolesRepository.save(userRole);
               return new SignUpResponse("Registered New User");
           }
    }
}
