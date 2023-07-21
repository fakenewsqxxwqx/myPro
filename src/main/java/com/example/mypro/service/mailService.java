package com.example.mypro.service;

import com.example.mypro.dto.request.changePasswordRequest;
import com.example.mypro.dto.request.forgetPasswordRequest;
import com.example.mypro.dto.response.ResponseResult;
import jakarta.servlet.http.HttpSession;

public interface mailService {


    ResponseResult<?> forgetPassword(forgetPasswordRequest forgetPasswordRequest, HttpSession session);

    ResponseResult<?> changePassword(changePasswordRequest changePasswordRequest, HttpSession session);
}
