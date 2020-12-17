package com.spring.ch_15.study_01;

import org.springframework.stereotype.Component;

@Component
public class SpitterService {
	
	public void addSpittle(String name){
		System.out.println("addSpittle " + name);
	}
	
	public void deleteSpittle(String name){
		System.out.println("deleteSpittle " + name);
	}
	
	public String getSpittle(){
		return "getSpittle";
	}

}
