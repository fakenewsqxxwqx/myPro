package com.example.mypro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mypro.bean.user;
import com.example.mypro.dto.request.userLoginRequest;
import com.example.mypro.dto.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.example.mypro.mapper.userMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class loginServiceimpl implements com.example.mypro.service.loginService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private userMapper userMapper;


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
}
