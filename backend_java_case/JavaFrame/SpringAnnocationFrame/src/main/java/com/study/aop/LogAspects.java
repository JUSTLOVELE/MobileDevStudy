package com.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;


@Aspect
public class LogAspects {

	@Pointcut("execution(public int com.study.aop.MathCalculator.*(..))")
	public void pointCut() {
		
	}

	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		
		Object[] args = joinPoint.getArgs();
		System.out.println("" + joinPoint.getSignature().getName());
		System.out.println("logStart:" + Arrays.toString(args));
	}
	
	@After("pointCut()")
	public void logEnd() {
		System.out.println("logEnd");
	}
	
	@AfterReturning(value="pointCut()", returning="result")
	public void logReturn() {
		System.out.println("pointCut:");
	}
	
	@AfterThrowing(value="pointCut()", throwing="exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		System.out.println(joinPoint.getSignature() + "logException:" + exception);
	}
}
