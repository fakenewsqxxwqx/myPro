package com.example.mypro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mypro.bean.product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface productMapper extends BaseMapper<product> {
}
