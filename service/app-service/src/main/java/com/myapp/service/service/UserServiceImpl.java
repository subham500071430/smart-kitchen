package com.myapp.service.service;

import com.myapp.service.dto.LoginRequest;
import com.myapp.service.dto.LoginResponse;
import com.myapp.service.dto.SignUpRequest;
import com.myapp.service.dto.SignUpResponse;
import com.myapp.service.entity.Role;
import com.myapp.service.entity.User;
import com.myapp.service.entity.UserRole;
import com.myapp.service.mapper.UserMapper;
import com.myapp.service.repository.UserRolesRepository;
import com.myapp.service.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

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


    @Transactional
    @Override
    public SignUpResponse signUp(SignUpRequest request){

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = userMapper.mapNewUser(request);
        UserRole userRole = new UserRole();
        userRole.setUser(user);

        try {
            userRole.setRole(Role.valueOf(request.getRole().toUpperCase()));
        } catch (Exception ex) {
            return new SignUpResponse("Invalid role " + request.getRole());
        }

        Optional<User> foundUser = usersRepository.findById(user.getEmailId());

        if (foundUser.isPresent()) {
            return new SignUpResponse("User Already Exists");
        } else {
            usersRepository.save(user);
            userRolesRepository.save(userRole);
            return new SignUpResponse("Registered New User");
        }
    }
}
