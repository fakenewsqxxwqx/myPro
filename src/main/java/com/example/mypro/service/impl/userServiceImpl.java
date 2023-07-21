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
    public UserDetails getUserById(String id) {
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        user user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        User user1 = new User(user.getName(), user.getPassword(), user.getAuthorities());
        return user1;
    }


}
