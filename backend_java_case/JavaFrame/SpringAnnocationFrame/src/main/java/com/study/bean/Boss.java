package com.study.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {
	
	private Car car;

	public Car getCar() {
		return car;
	}

	//��ע�ڷ���,Spring����������ǰ����,�ͻ���÷���,��ɸ�ֵ
	//����ʹ�õĲ���,�Զ������͵�ֵ��ioc�����л�ȡ
	@Autowired 
	public void setCar(Car car) {
		this.car = car;
	}
}
