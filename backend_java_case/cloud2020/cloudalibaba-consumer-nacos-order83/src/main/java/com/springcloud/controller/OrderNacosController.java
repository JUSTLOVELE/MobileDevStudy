package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangzl 2020.07.22

 */
@RestController
public class OrderNacosController {

    @Autowired
    private RestTemplate _restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURl;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return _restTemplate.getForObject(serverURl + "/payment/nacos/" + id, String.class);
    }
}
