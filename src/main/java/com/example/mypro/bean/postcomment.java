package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class postcomment {

    private String id;
    private LocalDateTime createtime;
    private boolean del;
    private String uid;
    private String text;
    private String postid;

}
