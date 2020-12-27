package com.example.basespringboot;

import com.example.basespringboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;


@RunWith(SpringRunner.class)
@SpringBootTest
class BasespringbootApplicationTests {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void test() {
        String key = "user:1";
        redisTemplate.opsForValue().set(key,new User(1,"haha",20));
        User user = (User) redisTemplate.opsForValue().get(key);
        System.out.println(user.toString());
    }

}
