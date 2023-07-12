package com.example.mypro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mypro.bean.admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface adminMapper extends BaseMapper<admin> {
    int insert(admin admin);
}
