package com.example.mypro.handler;

import com.alibaba.fastjson.JSON;
import com.example.mypro.dto.response.ResponseResult;
import com.example.mypro.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult<?> responseResult = new ResponseResult<>(401, "认证失败请重新登录");
        String json= JSON.toJSONString(responseResult);
        WebUtil.responseWrite(response, json);
    }
}
