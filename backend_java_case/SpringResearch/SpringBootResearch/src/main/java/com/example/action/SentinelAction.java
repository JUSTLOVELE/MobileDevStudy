package com.example.action;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelAction {

    @GetMapping("/sentinel/test1/{name}")
    @SentinelResource(value = "test1",blockHandler = "sentinelblockHandler", fallback = "sentinelFallBack")
    public String test1(@PathVariable("name") String name) {
        throw new RuntimeException();
//        return "heelo world:" + name;
    }

    public String sentinelblockHandler(String name, BlockException ex) {
        ex.printStackTrace();
        return "sentinelblockHandler:" + name;
    }

    public String sentinelFallBack(String name, Throwable throwable) {

        throwable.printStackTrace();
        return "sentinelFallBack:" + name;
    }

}
