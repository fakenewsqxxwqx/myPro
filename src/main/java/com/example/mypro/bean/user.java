package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class user {
    private String id;
    private String name;
    private String password;
    private String photourl;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private String role;
    private String mail;
    private boolean del;
}
