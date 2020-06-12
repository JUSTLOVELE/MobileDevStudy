package com.springcloud.controller;

import com.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService _paymentHystrixService;

    @GetMapping("/consumer/payment/hytrix/ok/{id}")
    public String paymentInfoOk(@PathVariable(value = "id") String id) {
        System.out.println(" paymentInfoOk order ");
        return _paymentHystrixService.paymentInfoOk(id);
    }

    //这里峰值在3秒以内走正常业务逻辑,超时走另外的
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @GetMapping("/consumer/payment/hytrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable(value = "id")  String id){

        //int age = 10/0
        System.out.println(" paymentInfoTimeOut order ");
        return _paymentHystrixService.paymentInfoTimeOut(id);
    }

    public String paymentInfoTimeOutHandler(String id) {
        return "我是80超时异常了";
    }

}
