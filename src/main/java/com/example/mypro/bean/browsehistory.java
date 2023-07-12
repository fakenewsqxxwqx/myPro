package com.example.mypro.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class browsehistory {

    private String id;
    private LocalDateTime createtime;
    private boolean del;
    private user user;
    private product product;
}
