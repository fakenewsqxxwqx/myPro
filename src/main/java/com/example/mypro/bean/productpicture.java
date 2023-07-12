package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class productpicture {

    private String id;
    private LocalDateTime createtime;
    private boolean del;
    private String pictureurl;
    private int picturegrade;
    private String productid;

}
