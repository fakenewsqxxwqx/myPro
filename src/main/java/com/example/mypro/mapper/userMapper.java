package com.example.mypro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mypro.bean.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userMapper extends BaseMapper<user>{
    void insertUser(user user);

    List<String> getAllUserName();
}
