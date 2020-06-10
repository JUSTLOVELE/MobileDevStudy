package com.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderAction {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/consul")
    public String consul() {
        return "hello consul";
    }
}
