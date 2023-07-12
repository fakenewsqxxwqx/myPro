package com.example.mypro.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class chatlist {

    private String id;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private boolean del;
    private user user1;
    private user user2;

}
