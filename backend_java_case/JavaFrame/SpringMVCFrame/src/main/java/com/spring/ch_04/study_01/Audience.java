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
 * Audience:定义了我们需要的切面
 * @Before : 目标方法调用之前执行
 * @Around : 通知方法会将目标方法封装起来(环绕通知)
 * @After  : 通知方法会目标方法返回或抛出异常后调用
 * @AfterReturning : 通知方法会在目标方法返回后调用
 * @AfterThrowing : 通知方法会在目标抛出异常后调用
 *
 * @Pointcut:能够在一个@AspectJ切面内定义可重用的切点
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

	//可以将表达式换为切点
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
	 * ProceedingJoinPoint jp这个参数是必须要有
	 * 因为要在通知中通过它来调用被通知的方法,通知方法中可以做任何的事情,
	 * 当要将控制权交给被通知方法时,它需要调用jp.proceed()方法
	 * 如果不调用的话,你的通知实际上会阻塞对被通知方的调用,
	 * 当然这样做也是有应用场景的:实现重试逻辑,也就是在被通知方法失败后进行重复尝试
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
