package com.springsesionredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
//@Controller
//@RequestMapping("helloAction")
public class HelloAction {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    //@RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/api/test01")
    public String test01() {
        return "hello world";
    }

    @GetMapping("/api/user/login")
    public String login(HttpServletRequest request, String userName, String pwd) {

        HttpSession session = request.getSession();
        session.setAttribute("logUserId", userName);
        redisTemplate.opsForValue().set("logUserId", userName);
        return session.getId();
    }
}