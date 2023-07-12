package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class poststar {

    private String id;
    private LocalDateTime createtime;
    private boolean del;
    private String postid;
    private String uid;

}
