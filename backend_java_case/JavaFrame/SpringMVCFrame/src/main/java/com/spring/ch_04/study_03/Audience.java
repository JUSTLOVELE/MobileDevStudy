package com.spring.ch_04.study_03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;

public class Audience {
	
	public Audience audience(){
		return new Audience();
	}
	
	public void silenceCellPhones(){
		System.out.println("silencing cell phones");
	}
	
	public void takeSeats(){
		System.out.println("Taking seats");
	}
	
	public void applause(){
		System.out.println("CLAP CLAP CLAP");
	}
	
	public void demandRefund(){
		System.out.println("Demanding a refund");
	}
	
	public void watchPerformance(ProceedingJoinPoint jp){
		try {
			System.out.println("silencing cell phones");
			System.out.println("Taking seats");
			jp.proceed();
			System.out.println("CLAP CLAP CLAP");
		} catch (Throwable e) {
			System.out.println("Demanding a refund");
		}
	}
}
