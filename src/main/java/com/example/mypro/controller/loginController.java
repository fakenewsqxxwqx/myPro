package com.example.mypro.controller;

import com.example.mypro.dto.request.userLoginRequest;
import com.example.mypro.dto.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mypro.service.loginService;

@RestController
public class loginController {

    @Autowired
    private loginService loginService;

    @PostMapping("/login")
    public ResponseResult<?> login(@RequestBody userLoginRequest userLoginRequest){
        return loginService.login(userLoginRequest);
    }

}
