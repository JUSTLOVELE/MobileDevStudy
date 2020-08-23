package com.yzl.webflux.controller;

import com.yzl.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloWebFluxController {

    @GetMapping("/hello")
    public String hello() {
        return "hello, webflux";
    }

    @GetMapping("/flux")
    public Flux<String> flux()  {
        return Flux.just("test02", "test03");
    }

    //mono用于返回0或1个元素
    @GetMapping("/user")
    public Mono<User> getUser() {
        User user = new User();
        user.setName(String.valueOf(this.hashCode()));
        user.setDesc("user name");
        return Mono.just(user);
    }


}
