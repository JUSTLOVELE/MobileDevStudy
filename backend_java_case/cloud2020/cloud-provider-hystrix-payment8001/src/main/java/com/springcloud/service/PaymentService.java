package com.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    //正常访问不报错的
    public String paymentInfoOk(String id) {

        return "线程池:" + Thread.currentThread().getName() + "; paymentInfoOk, id =" + id;
    }


    public String paymentInfoTimeOut(String id) {

        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "线程池:" + Thread.currentThread().getName() + "; paymentInfoTimeOut, id =" + id;

    }
}
