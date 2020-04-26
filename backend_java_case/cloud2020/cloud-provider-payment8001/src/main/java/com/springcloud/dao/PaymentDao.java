package com.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springcloud.entities.Payment;

@Mapper
public interface PaymentDao {

	public int create(Payment payment);
	
	public Payment getPaymentById(@Param("id") String id);
}
