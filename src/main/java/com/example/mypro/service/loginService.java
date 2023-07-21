package com.example.mypro.service;


import com.example.mypro.dto.request.changePasswordRequest;
import com.example.mypro.dto.request.forgetPasswordRequest;
import com.example.mypro.dto.request.userLoginRequest;
import com.example.mypro.dto.request.userRegRequest;
import com.example.mypro.dto.response.ResponseResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;

public interface loginService {

    ResponseResult<?> login(userLoginRequest userLoginRequest);

    ResponseResult<?> register(userRegRequest userRegRequest);

}
