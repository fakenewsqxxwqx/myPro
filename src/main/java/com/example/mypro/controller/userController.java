package com.example.mypro.controller;

import com.example.mypro.dto.request.userLoginRequest;
import com.example.mypro.dto.request.userRegRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.example.mypro.service.userService;

import java.util.Collection;

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

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("test");
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody userRegRequest userRegRequest){
        return userService.register(userRegRequest);
    }
}
