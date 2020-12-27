package com.example.basespringboot.controller;

import com.example.basespringboot.pojo.User;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    private static final String product = "moonCake";

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(1234);
        return "hello";
    }

    @RequestMapping("/redisson")
    public String redisson(){
        RLock lock = redissonClient.getLock(product);
        lock.lock(10, TimeUnit.MINUTES);

        int stock = Integer.parseInt(redisTemplate.opsForValue().get("stock").toString());
        if(stock > 0){
            int realstock = (stock - 1);
            redisTemplate.opsForValue().set("stock",String.valueOf(realstock));
            System.out.println("秒杀成功");
        } else{
            System.out.println("秒杀失败");
        }
        lock.unlock();
        return "test";
    }

    @RequestMapping("/seckill")
    public String seckill(){
        int stock = Integer.parseInt(redisTemplate.opsForValue().get("stock").toString());
        if(stock > 0){
            int realstock = (stock - 1);
            redisTemplate.opsForValue().set("stock",String.valueOf(realstock));
            return "秒杀成功";
        } else{
            return "秒杀失败";
        }
    }

    @RequestMapping("/redis")
    public String redis(){
        String key = "user:1";
        redisTemplate.opsForValue().set(key,new User(1,"haha",20));
        User user = (User) redisTemplate.opsForValue().get(key);
        return user.toString();
    }

}
