package com.example.mypro.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class bill {

    private String id;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private boolean del;
    private product product;
    private String startaddress;
    private String endaddress;
    private String billstatus;
    private user buyer;
}
