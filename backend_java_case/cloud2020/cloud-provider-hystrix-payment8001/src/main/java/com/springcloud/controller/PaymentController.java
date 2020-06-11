package com.springcloud.controller;

import com.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService _paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hytrix/ok/{id}")
    public String paymentInfoOk(@PathVariable String id) {

        String s = _paymentService.paymentInfoOk(id);
        return s;
    }

    @GetMapping("/payment/hytrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable  String id) {

        String s = _paymentService.paymentInfoTimeOut(id);
        return s;
    }

}
