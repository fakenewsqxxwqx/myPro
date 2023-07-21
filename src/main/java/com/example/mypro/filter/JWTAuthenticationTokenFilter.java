package com.example.mypro.filter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.mypro.utils.jwtUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class JWTAuthenticationTokenFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("authorization");

        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        token=token.substring(7);
        //验证token
        try {
            Claims claims = jwtUtil.decodeToken(token);
        }catch (Exception e) {
            throw new RuntimeException("token无效");
        }

        String str=jwtUtil.getAuthorities(token).toString();
        String str1=str.substring(str.indexOf("=") + 1, str.indexOf("}"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(str1));


        //将用户信息存入SecurityContext
        Authentication authentication = new UsernamePasswordAuthenticationToken(jwtUtil.getName(token),null,authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request,response);

    }
}
