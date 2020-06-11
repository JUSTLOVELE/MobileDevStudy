package com.springcloud.controller;

import com.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService _paymentHystrixService;

    @GetMapping("/consumer/payment/hytrix/ok/{id}")
    public String paymentInfoOk(@PathVariable(value = "id") String id) {
        System.out.println(" paymentInfoOk order ");
        return _paymentHystrixService.paymentInfoOk(id);
    }

    @GetMapping("/consumer/payment/hytrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable(value = "id")  String id){
        System.out.println(" paymentInfoTimeOut order ");
        return _paymentHystrixService.paymentInfoTimeOut(id);
    }
}
