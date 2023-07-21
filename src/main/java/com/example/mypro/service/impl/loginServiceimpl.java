package com.example.mypro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mypro.bean.user;
import com.example.mypro.dto.request.changePasswordRequest;
import com.example.mypro.dto.request.forgetPasswordRequest;
import com.example.mypro.dto.request.userLoginRequest;
import com.example.mypro.dto.request.userRegRequest;
import com.example.mypro.dto.response.ResponseResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.example.mypro.mapper.userMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class loginServiceimpl implements com.example.mypro.service.loginService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private userMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseResult<?> login(userLoginRequest userLoginRequest) {

        //调用providerManager.authenticate()方法进行登录验证，返回Authentication对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginRequest.getName(),userLoginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        //判断authentication是否为空
        if(Objects.isNull(authentication)) {
            throw new RuntimeException("用户名或密码错误");
        }

        //如果返回的Authentication对象不为空，则生成jwt并返回
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userLoginRequest.getName());
        user user = userMapper.selectOne(queryWrapper);
        String jwt = com.example.mypro.utils.jwtUtil.generateToken(user.getId(),user.getAuthorities());

        //返回jwt
        return new ResponseResult<>("登录成功",jwt);
    }

    @Override
    public ResponseResult<?> register(userRegRequest userRegRequest) {
        try {
            user user = new user();
            user.setId(UUID.randomUUID().toString());
            user.setName(userRegRequest.getName());
            user.setPassword(passwordEncoder.encode(userRegRequest.getPassword()));
            user.setPhotourl(userRegRequest.getPhotourl());
            user.setMail(userRegRequest.getMail());

            //查看是否有重复的用户名
            QueryWrapper<user> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", userRegRequest.getName());
            user user1 = userMapper.selectOne(queryWrapper);
            if(!Objects.isNull(user1)){
                return new ResponseResult<>(400,"用户名已存在");
            }

            //查看是否有重复的邮箱
            QueryWrapper<user> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("mail", userRegRequest.getMail());
            user user2 = userMapper.selectOne(queryWrapper1);
            if(!Objects.isNull(user2)){
                return new ResponseResult<>(400,"邮箱已存在");
            }

            userMapper.insertUser(user);
            return new ResponseResult<>("注册成功");
        }catch (Exception e){
            return new ResponseResult<>(400,"注册失败");
        }
    }

}
