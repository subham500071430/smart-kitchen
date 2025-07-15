package com.myapp.service.service;

import com.myapp.service.dto.*;
import com.myapp.service.entity.Role;
import com.myapp.service.entity.User;
import com.myapp.service.entity.UserRole;
import com.myapp.service.mapper.UserMapper;
import com.myapp.service.repository.UserRolesRepository;
import com.myapp.service.repository.UsersRepository;
import com.myapp.service.security.JwtUtil;
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
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public JwtLoginResponse login(LoginRequest request) {

        User user = userMapper.toExistingUser(request);

        if (usersRepository.existsById(user.getEmailId())) {
            String encodedPassword = usersRepository.findById(user.getEmailId()).get().getPassword();
            if (passwordEncoder.matches(request.getPassword(), encodedPassword)) {
                String token = jwtUtil.generateToken(user.getEmailId());
                return new JwtLoginResponse(token);
            }
        }
        return new JwtLoginResponse();
    }


    @Transactional
    @Override
    public SignUpResponse signUp(SignUpRequest request) {

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = userMapper.mapNewUser(request);
        UserRole userRole = new UserRole();
        userRole.setUser(user);

        try {
            userRole.setRole(Role.valueOf(request.getRole().toUpperCase()));
        } catch (Exception ex) {
            return new SignUpResponse("Invalid role " + request.getRole(), false);
        }

        if (usersRepository.existsById(user.getEmailId())) {
            return new SignUpResponse("User Already Exists", false);
        } else {
            usersRepository.save(user);
            userRolesRepository.save(userRole);
            return new SignUpResponse("Registered New User", true);
        }
    }

    @Override
    public UserDetails getUserById(String userId) {
           Optional<User> user = usersRepository.findById(userId);
           return user.map(value -> new UserDetails(value.getEmailId(), value.getName())).orElseGet(UserDetails::new);
    }

    @Override
    public boolean updatePassword(String userId, UpdatePasswordRequest updatePasswordRequest) {

           // verify old password
           Optional<User> user = usersRepository.findById(userId);

           if(user.isEmpty() || !passwordEncoder.matches(updatePasswordRequest.getOldPassword() , user.get().getPassword()))
               return false;

           int rowsUpdated = usersRepository.updatePassword(userId , passwordEncoder.encode(updatePasswordRequest.getNewPassword()));
           return rowsUpdated > 0 ;
    }
}
