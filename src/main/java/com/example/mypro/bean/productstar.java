package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class productstar {

    private String id;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private boolean del;
    private String uid;
    private String productid;
}
