package com.example.mypro.service;


import com.example.mypro.dto.request.userLoginRequest;
import com.example.mypro.dto.response.ResponseResult;
import org.springframework.http.ResponseEntity;

public interface loginService {

    ResponseResult<?> login(userLoginRequest userLoginRequest);
}
