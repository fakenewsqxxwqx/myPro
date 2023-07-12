package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class searchhistory {

    private String id;
    private LocalDateTime createtime;
    private boolean del;
    private String uid;
    private String keyword;
}
