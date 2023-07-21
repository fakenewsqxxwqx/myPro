package com.example.mypro.service;

import com.example.mypro.bean.user;
import com.example.mypro.dto.request.userLoginRequest;
import com.example.mypro.dto.request.userRegRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface userService extends UserDetailsService {


    UserDetails getUserById(String id);

}
