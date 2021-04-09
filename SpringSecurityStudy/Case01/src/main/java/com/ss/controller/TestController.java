package com.ss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzl 2021.03.29
 * @version 1.00.00
 * @Description:
 * @history:
 */
@RestController
public class TestController {

    @GetMapping(value = "/test/add", produces = "application/json; charset=utf-8")
    public String add() {
        return "hello security";
    }

    @GetMapping(value = "/test/index", produces = "application/json; charset=utf-8")
    public String index() {
        return "hello index";
    }
}
