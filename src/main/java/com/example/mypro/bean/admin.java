package com.example.mypro.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class admin {
    private String id;
    private String name;
    private String password;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private String role;
    private boolean del;
}
