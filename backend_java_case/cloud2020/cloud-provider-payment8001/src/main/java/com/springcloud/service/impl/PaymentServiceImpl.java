package com.springcloud.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springcloud.dao.PaymentDao;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private PaymentDao PaymentDao;
	
	@Override
	public int create(Payment payment) {
		
		PaymentDao.create(payment);
		return 1;
	}

	@Override
	public Payment getPaymentById(String id) {
		
		return PaymentDao.getPaymentById(id);
	}

}
