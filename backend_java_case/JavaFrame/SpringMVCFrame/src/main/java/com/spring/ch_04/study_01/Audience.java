package com.spring.ch_04.study_01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;

/**
 * Audience:������������Ҫ������
 * @Before : Ŀ�귽������֮ǰִ��
 * @Around : ֪ͨ�����ὫĿ�귽����װ����(����֪ͨ)
 * @After  : ֪ͨ������Ŀ�귽�����ػ��׳��쳣�����
 * @AfterReturning : ֪ͨ��������Ŀ�귽�����غ����
 * @AfterThrowing : ֪ͨ��������Ŀ���׳��쳣�����
 * 
 * @Pointcut:�ܹ���һ��@AspectJ�����ڶ�������õ��е�
 * 
 * 
 * @author Administrator
 *
 */
@Aspect
public class Audience {
	
	@Bean
	public Audience audience(){
		return new Audience();
	}
	//https://www.cnblogs.com/guzhou-ing/p/6445159.html
	@Pointcut("execution(** com.spring.ch_04.study_01.Performance.*(..))")
	public void performance(){}
	
	//���Խ����ʽ��Ϊ�е�
	//@Before("execution(** com.spring.ch_04.study_01.Performance.perform(..))")
	@Before("performance()")
	public void silenceCellPhones(){
		System.out.println("silencing cell phones");
	}
	
	@Before("execution(** com.spring.ch_04.study_01.Performance.perform(..))")
	public void takeSeats(){
		System.out.println("Taking seats");
	}
	
	@AfterReturning("execution(** com.spring.ch_04.study_01.Performance.perform(..))")
	public void applause(){
		System.out.println("CLAP CLAP CLAP");
	}
	
	@AfterThrowing("execution(** com.spring.ch_04.study_01.Performance.perform(..))")
	public void demandRefund(){
		System.out.println("Demanding a refund");
	}
	
	/**
	 * ProceedingJoinPoint jp��������Ǳ���Ҫ��
	 * ��ΪҪ��֪ͨ��ͨ���������ñ�֪ͨ�ķ���,֪ͨ�����п������κε�����,
	 * ��Ҫ������Ȩ������֪ͨ����ʱ,����Ҫ����jp.proceed()����
	 * ��������õĻ�,���֪ͨʵ���ϻ������Ա�֪ͨ���ĵ���,
	 * ��Ȼ������Ҳ����Ӧ�ó�����:ʵ�������߼�,Ҳ�����ڱ�֪ͨ����ʧ�ܺ�����ظ�����
	 * @param jp
	 */
	@Around("performance()")
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
