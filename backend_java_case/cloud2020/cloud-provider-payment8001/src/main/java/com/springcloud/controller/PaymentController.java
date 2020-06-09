package com.springcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;

import net.bytebuddy.asm.Advice.This;

@RestController
public class PaymentController {

	@Resource
	private PaymentService paymentService;
	
	@Resource
	private DiscoveryClient discoveryClient;
	
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

		System.out.println(id);
		Payment p = paymentService.getPaymentById(id);
		
		if(p != null) {
			return new CommonResult(200, "查詢成功,server.port=" + serverPort, p);
		}else {
			return new CommonResult(444, "查詢失敗:id=" + id);
		}
	}
	
	@GetMapping(value = "/payment/discovery")
	public Object discovery() {
		
		List<String> services = discoveryClient.getServices();
		
		for(String element: services) {
			System.out.println(" element: " + element);
		}
		
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
		
		for(ServiceInstance instance: instances) {
			System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
		}
		
		return this.discoveryClient;
	}
}
