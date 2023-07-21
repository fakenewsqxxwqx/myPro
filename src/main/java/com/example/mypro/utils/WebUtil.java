package com.example.mypro.utils;

import jakarta.servlet.http.HttpServletResponse;

import java.net.http.HttpResponse;

public class WebUtil {

    public static void responseWrite(HttpServletResponse response, String msg) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
