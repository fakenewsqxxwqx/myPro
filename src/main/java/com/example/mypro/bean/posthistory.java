package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class posthistory {

    private String id;
    private LocalDateTime createtime;
    private boolean del;
    private String postid;
    private String uid;

}
