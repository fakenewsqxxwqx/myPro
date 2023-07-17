package com.example.mypro.dto.request;

import lombok.Data;

@Data
public class userRegRequest {
    private String name;
    private String password;
    private String photourl;
    private String role;
    private String mail;
}
