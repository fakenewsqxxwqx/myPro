package com.example.mypro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mypro.bean.user;
import com.example.mypro.dto.request.userRegRequest;
import com.example.mypro.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.mypro.mapper.userMapper;

import java.util.UUID;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper userMapper;

    @Autowired
    private PasswordEncoder PasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);
        user user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        User user1 = new User(user.getName(), user.getPassword(), user.getAuthorities());
        return user1;
    }

    @Override
    public ResponseEntity<?> register(userRegRequest userRegRequest) {
        //判断用户名是否存在
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userRegRequest.getName());
        user user1 = userMapper.selectOne(queryWrapper);
        if (user1 != null) {
            return ResponseEntity.ok("用户名已存在");
        }
        //判断邮箱是否存在
        QueryWrapper<user> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("mail", userRegRequest.getMail());
        user user2 = userMapper.selectOne(queryWrapper1);
        if (user2 != null) {
            return ResponseEntity.ok("邮箱已存在");
        }
        //注册用户
        user user = new user();
        user.setId(UUID.randomUUID().toString());
        user.setName(userRegRequest.getName());
        user.setPassword(PasswordEncoder.encode(userRegRequest.getPassword()));
        user.setPhotourl(userRegRequest.getPhotourl());
        user.setRole(userRegRequest.getRole());
        user.setMail(userRegRequest.getMail());
        userMapper.insertUser(user);
        return ResponseEntity.ok("注册成功");
    }
}
