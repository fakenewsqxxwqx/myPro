package com.example.mypro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mypro.bean.admin;
import com.example.mypro.mapper.adminMapper;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
public class adminMapperTest {

    @Autowired
    private adminMapper adminMapper;

    @Test
    public void test() {
        admin admin = new admin();
        admin.setId(UUID.randomUUID().toString());
        admin.setName("admin");
        admin.setPassword("123456");
        admin.setCreatetime(LocalDateTime.now());
        admin.setUpdatetime(LocalDateTime.now());
        admin.setDel(false);
        admin.setRole("admin");
        adminMapper.insert(admin);
    }
}
