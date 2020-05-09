package com.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;

@RestController
public class PaymentController {

	@Resource
	private PaymentService paymentService;
	
	@Value("${server.port}")
	private String serverPort;
	
	@PostMapping(value = "/payment/create")
	public CommonResult create(@RequestBody Payment payment) {
		
		int result = paymentService.create(payment);
		
		if(result > 0) {
			return new CommonResult(200, "插入成功,server.port=" + serverPort, result);
		}else {
			return new CommonResult(444, "插入失敗");
		}
	}
	
	/**
	 * 访问方法:http://localhost:8001/cloud-provider-payment/payment/get/tt
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/payment/get/{id}")
	public CommonResult getParamById(@PathVariable("id") String id) {
		
		Payment p = paymentService.getPaymentById(id);
		
		if(p != null) {
			return new CommonResult(200, "查詢成功,server.port=" + serverPort, p);
		}else {
			return new CommonResult(444, "查詢失敗:id=" + id);
		}
	}
}
