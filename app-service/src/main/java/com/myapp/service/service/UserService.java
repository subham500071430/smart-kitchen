package com.myapp.service.service;

import com.myapp.service.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

       JwtLoginResponse login(LoginRequest request);

       SignUpResponse signUp(SignUpRequest request) ;

       UserDetails getUserById(String userId);

       boolean updatePassword(String userId , UpdatePasswordRequest updatePasswordRequest);
}
