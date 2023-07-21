package com.example.mypro.controller;

import com.example.mypro.dto.request.changePasswordRequest;
import com.example.mypro.dto.request.forgetPasswordRequest;
import com.example.mypro.dto.request.userLoginRequest;
import com.example.mypro.dto.request.userRegRequest;
import com.example.mypro.dto.response.ResponseResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mypro.service.loginService;
import com.example.mypro.service.mailService;

@RestController
public class loginController {

    @Autowired
    private loginService loginService;

    @Autowired
    private mailService mailService;


    @PostMapping("/login")
    public ResponseResult<?> login(@RequestBody userLoginRequest userLoginRequest){
        return loginService.login(userLoginRequest);
    }

    @PostMapping("/register")
    public ResponseResult<?> register(@RequestBody userRegRequest userRegRequest){
        return loginService.register(userRegRequest);
    }

    @PostMapping("/forgetPassword")
    public ResponseResult<?> forgetPassword(@RequestBody forgetPasswordRequest forgetPasswordRequest, HttpSession session){
        return mailService.forgetPassword(forgetPasswordRequest,session);
    }

    @PostMapping("/changePassword")
    public ResponseResult<?> changePassword(@RequestBody changePasswordRequest changePasswordRequest, HttpSession session){
        return mailService.changePassword(changePasswordRequest,session);
    }

}
