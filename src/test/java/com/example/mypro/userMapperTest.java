package com.example.mypro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class userMapperTest {
    @Autowired
    private com.example.mypro.mapper.userMapper userMapper;

    @Test
    public void test(){
        List<String> allUserName = userMapper.getAllUserName();
        System.out.println(allUserName);
    }
}
