package com.example.mypro.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class chat {

    private String id;
    private LocalDateTime createtime;
    private boolean del;
    private user sender;
    private user accepter;
    private String content;

}
