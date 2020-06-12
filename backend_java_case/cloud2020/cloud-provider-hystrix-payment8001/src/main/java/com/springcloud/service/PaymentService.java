package com.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    //正常访问不报错的
    public String paymentInfoOk(String id) {

        return "线程池:" + Thread.currentThread().getName() + "; paymentInfoOk, id =" + id;
    }

    //这里峰值在3秒以内走正常业务逻辑,超时走另外的
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeOut(String id) {

        try {
            TimeUnit.SECONDS.sleep(3);
            //或者计算错误也能降级
            //int age = 10/0
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "线程池:" + Thread.currentThread().getName() + "; paymentInfoTimeOut, id =" + id;
    }

    public String paymentInfoTimeOutHandler(String id) {
        return "线程池:" + Thread.currentThread().getName() + "; paymentInfoTimeOutHandler, id =" + id;
    }


}
