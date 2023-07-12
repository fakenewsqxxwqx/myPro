package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class concern {

    private String id;
    private LocalDateTime createtime;
    private user user1;
    private user user2;
    private boolean del;
}
