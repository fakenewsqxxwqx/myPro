package com.example.mypro.controller;

import com.example.mypro.dto.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mypro.service.userService;

@RestController
@RequestMapping("/home")
public class userController {

    @Autowired
    private userService userService;
    //登录


    @GetMapping("/test")
    public ResponseResult<?> test(){
        String test = "test";
        return new ResponseResult<>("success",test);
    }

}
