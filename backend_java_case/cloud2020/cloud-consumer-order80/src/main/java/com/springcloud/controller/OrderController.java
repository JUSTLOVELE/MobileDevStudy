package com.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;

@SuppressWarnings("unchecked")
@RestController
public class OrderController {

	//public static final String PAYMENT_URL = "http://localhost:8001";
	public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT";
	
	@Resource
	private RestTemplate restTemplate;
	
	@GetMapping("/consumer/payment/create")
	public CommonResult<Payment> create(Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}
	
	//http://localhost/consumer/payment/get/tt
	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") String id) {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}
	
	@GetMapping("/consumer/payment/getForEntity/{id}")
	public CommonResult<Payment> getPayment2(@PathVariable("id") String id) {
		
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
		
		if(entity.getStatusCode().is2xxSuccessful()) {
			return entity.getBody();
		}else {
			return new CommonResult<>(444, "操作失败");
		}
	}
}
