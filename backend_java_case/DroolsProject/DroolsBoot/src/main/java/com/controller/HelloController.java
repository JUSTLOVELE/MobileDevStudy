package com.controller;

import com.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzl 2020.10.21
 * @version 1.00.00
 * @Description:
 * @history:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private RuleService ruleService;

    @RequestMapping("/rule")
    public String rule(){

        ruleService.rule();
        return "OK";
    }
}
