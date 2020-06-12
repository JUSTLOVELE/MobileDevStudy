package com.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements  PaymentHystrixService{
    @Override
    public String paymentInfoOk(String id) {
        return "-------PaymentHystrixServiceImpl fall back paymentInfoOk -----------";
    }

    @Override
    public String paymentInfoTimeOut(String id) {
        return "-------PaymentHystrixServiceImpl fall back paymentInfoTimeOut -----------";
    }
}
