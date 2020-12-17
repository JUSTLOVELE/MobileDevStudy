package com.spring.ch_04.study_01;

import org.springframework.stereotype.Component;

@Component
public class Movie implements Performance{

	public void perform() {
		System.out.println("ÇÐµã1....");
	}

	@Override
	public void perform_v2() {
		// TODO Auto-generated method stub
		System.out.println("ÇÐµã2....");
	}

}
