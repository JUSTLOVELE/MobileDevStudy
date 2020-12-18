package com.example.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisAction {

    @Autowired
    @Qualifier("stringRedisTemplate")
    private StringRedisTemplate _redisTemplate;

    @Autowired
    private RedisTemplate<String, Object> _redisTemplate02;

    @GetMapping("/redisTest3")
    public String redisTest3() {
        _redisTemplate02.opsForValue().set("name02", "yzl222");
        String n = (String) _redisTemplate02.opsForValue().get("name02");
        System.out.println(n);
        return n;
    }

    @GetMapping("/redisTest1")
    public String redisTest1() {
       return _redisTemplate.opsForValue().get("name");
    }

    @GetMapping("/redisTest2")
    public String redisTest2() {
        _redisTemplate.opsForValue().set("name", "yzl");
        return "save oK";
    }
}
