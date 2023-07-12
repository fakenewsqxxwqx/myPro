package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class loginlog {
    private String id;
    private LocalDateTime createtime;
    private String userid;
    private boolean del;

}
