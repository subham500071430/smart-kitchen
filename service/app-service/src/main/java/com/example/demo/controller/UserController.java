package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.dto.UserLoginRequest;
import com.example.demo.UserMapper;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserMapper userMapper;

    @PostMapping(path = "/addUser")
    public void addNewUser(@RequestBody UserLoginRequest loginRequest) {
        User user = userMapper.mapToUser(loginRequest);
        usersRepository.save(user);
    }

    @GetMapping(path = "/getAllUsers")
    @ResponseBody
    public Iterable<User> getAllUser() {
        Iterable<User> users = usersRepository.findAll();

        return users;
    }

    @PostMapping(path = "/validateUser")
    @ResponseBody
    public boolean validateUser(@RequestBody UserLoginRequest userDTO){

        User user = userMapper.mapToUser(userDTO);

        Optional<User> optionalUser = usersRepository.findById(user.getEmail_id());

         if(!optionalUser.isEmpty()){

             if(optionalUser.get().getPassword().equals(user.getPassword())){
                 return true;
             }
         }

         return false;
    }

    @GetMapping(path = "/hello")
    public String getHello(){
        return "Hello";
    }
}
