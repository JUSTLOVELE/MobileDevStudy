package com.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * ������
 * @author Administrator
 *
 */
@Aspect
public class LogAspects {
	
	/**
	 * ��ȡ�������е���ʽ
	 * 1.��������
	 * 2.��������������
	 */
	@Pointcut("execution(public int com.study.aop.MathCalculator.*(..))")
	public void pointCut() {
		
	}

	//@Before("public int com.study.aop.MathCalculator(int, int)")\
	//joinPointҪ���ڲ����б�ĵ�һλ
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		
		Object[] args = joinPoint.getArgs();
		System.out.println("" + joinPoint.getSignature().getName());
		System.out.println("���п�ʼ...������:" + Arrays.toString(args));
	}
	
	@After("pointCut()")
	public void logEnd() {
		System.out.println("���н���...������:");
	}
	
	@AfterReturning(value="pointCut()", returning="result")
	public void logReturn() {
		System.out.println("���з���...������:");
	}
	
	@AfterThrowing(value="pointCut()", throwing="exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		System.out.println(joinPoint.getSignature() + "�����쳣...������:" + exception);
	}
}
