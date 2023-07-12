package com.example.mypro.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class purchasewander {

    private String id;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private boolean del;
    private String wanderbro;
    private String uid;

}
