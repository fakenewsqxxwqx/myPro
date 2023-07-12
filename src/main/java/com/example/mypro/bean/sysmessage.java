package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class sysmessage {

    private String id;
    private LocalDateTime createtime;
    private boolean del;
    private String content;
    private String uid;

}
