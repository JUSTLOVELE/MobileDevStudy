package com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYTRIX-PAYMENT", fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hytrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") String id);

    @GetMapping("/payment/hytrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id")  String id);
}
