package com.spring.ch_04.study_03;

import org.springframework.stereotype.Component;

@Component
public class Movie implements Performance{

	public void perform() {
		System.out.println("Movie perform....");
	}

}
