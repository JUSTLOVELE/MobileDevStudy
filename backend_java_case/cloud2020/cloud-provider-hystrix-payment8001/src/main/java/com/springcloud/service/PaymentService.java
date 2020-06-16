package com.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //==============服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {

        if(id < 0) {
            throw new RuntimeException("********id不能为负数");
        }

        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功,流水号:" + serialNumber;
    }

    public String paymentCircuitBreakerFallBack(@PathVariable("id") Integer id) {
        return "id不能为负数,稍后再试";
    }
}
