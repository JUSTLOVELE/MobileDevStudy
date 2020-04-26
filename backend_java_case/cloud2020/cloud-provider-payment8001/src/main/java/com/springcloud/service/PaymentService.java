package com.springcloud.service;

import org.apache.ibatis.annotations.Param;

import com.springcloud.entities.Payment;

public interface PaymentService {

	public int create(Payment payment);
	
	public Payment getPaymentById(@Param("id") String id);
}
