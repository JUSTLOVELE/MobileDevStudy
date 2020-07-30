package com.springcloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzl 2020.07.30
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------------testB";
    }




}
