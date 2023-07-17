package com.example.mypro.controller;

import com.example.mypro.dto.request.userLoginRequest;
import com.example.mypro.dto.request.userRegRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.mypro.service.userService;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;
    //登录
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody userLoginRequest userLoginRequest){
        return null;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody userRegRequest userRegRequest){
        return userService.register(userRegRequest);
    }
}
