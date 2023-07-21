package com.example.mypro.handler;

import com.alibaba.fastjson.JSON;
import com.example.mypro.dto.response.ResponseResult;
import com.example.mypro.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult<?> responseResult = new ResponseResult<>(403, "权限不足");
        String json= JSON.toJSONString(responseResult);
        WebUtil.responseWrite(response, json);
    }
}
