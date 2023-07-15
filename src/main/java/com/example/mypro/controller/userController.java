package com.example.mypro.controller;

import com.example.mypro.dto.request.userLoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {

    //登录
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody userLoginRequest userLoginRequest){
        return null;
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        ResponseEntity<?> responseEntity = ResponseEntity.ok("test");
        return responseEntity;
    }
}
