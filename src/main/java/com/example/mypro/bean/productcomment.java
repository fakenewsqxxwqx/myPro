package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class productcomment {

    private String id;
    private LocalDateTime createtime;
    private boolean del;
    private String productid;
    private String commenttext;
    private String uid;
}
