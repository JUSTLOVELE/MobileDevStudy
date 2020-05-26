package com.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;

@RestController
public class OrderController {

	public static final String INVOKE_URL = "http://cloud-provider-payment";
	
	@Resource
	private RestTemplate restTemplate;

	//http://localhost/consumer/consul
	@GetMapping(value = "/consumer/consul")
	public String paymentInfo() {
		
		String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
		return result;
	}
}
