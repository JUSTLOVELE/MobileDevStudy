package com.ss.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping(value = "/test/logout", produces = "application/json; charset=utf-8")
    public String testLogout() {
        return "hello logout";
    }

    @GetMapping(value = "/test/add", produces = "application/json; charset=utf-8")
    public String add() {
        return "hello security";
    }

    @GetMapping(value = "/test/index", produces = "application/json; charset=utf-8")
    public String index() {
        return "hello index";
    }

    /**
     * 只有具有这两个角色的方能访问
     * @return
     */
    @Secured({"ROLE_sale1", "ROLE_manager"})
    @GetMapping("/update")
    public String update() {
        return "hello update";
    }

    @GetMapping("/update02")
    @PreAuthorize("hasAnyAuthority('admins')")
    public String update02() {
        return "hello update02";
    }

    @GetMapping("/update03")
    @PostAuthorize("hasAnyAuthority('admins1')")
    public String update03() {
        System.out.println("hello update03");
        return "hello update03";
    }
}
