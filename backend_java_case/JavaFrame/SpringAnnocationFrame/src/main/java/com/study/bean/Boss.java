package com.study.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {
	
	private Car car;

	public Car getCar() {
		return car;
	}

	//标注在方法,Spring容器创建当前对象,就会调用方法,完成赋值
	//方法使用的参数,自定义类型的值从ioc容器中获取
	@Autowired 
	public void setCar(Car car) {
		this.car = car;
	}
}
