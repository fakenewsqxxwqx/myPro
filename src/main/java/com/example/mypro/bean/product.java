package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class product {

    private String id;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private boolean del;
    private String productname;
    private String uid;
    private String productbro;
    private String tag;
    private String productstatus;
    private int price;
}
