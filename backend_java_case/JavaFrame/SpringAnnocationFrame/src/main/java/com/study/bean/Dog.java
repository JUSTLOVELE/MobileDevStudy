package com.study.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {

	public Dog() {
		System.out.println("Dog construct");
	}
	
	//���󴴽�����ֵ֮�����
	@PostConstruct
	public void init() {
		System.out.println("dog init");
	}
	
	//����֮ǰ,�����Ƴ�����
	@PreDestroy
	public void destory() {
		System.out.println("dog destory");
	}
}
