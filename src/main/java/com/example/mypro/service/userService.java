package com.example.mypro.service;

import com.example.mypro.dto.request.userRegRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface userService extends UserDetailsService {

    ResponseEntity<?> register(userRegRequest userRegRequest);
}
