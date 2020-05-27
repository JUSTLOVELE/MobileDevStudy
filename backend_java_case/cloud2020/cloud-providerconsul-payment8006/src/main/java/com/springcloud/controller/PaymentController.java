package com.springcloud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;
	
	@RequestMapping(value = "/payment/consul")
	public String paymentConsul() {
		return "Springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
	}
}
