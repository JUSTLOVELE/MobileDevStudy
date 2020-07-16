package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzl 2020.07.16
 * @version 1.00.00
 * @Description:
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @Company: 福建互医科技有限公司
 * @history:
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {


    @Value("${server.port}")
    private String severPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {

        System.out.println("消费者1号,--->接收到的消息: " + message.getPayload() + "\t port: " + severPort);
    }

}
