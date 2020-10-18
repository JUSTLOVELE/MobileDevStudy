package com.java8.annotation.study;

import java.lang.reflect.Method;

import org.junit.Test;


/**
 * 重复注解与类型注解
 * @author Administrator
 *
 */
public class TestAnnotation {

	@Test
	public void test1() {

		try {

			Class<TestAnnotation> clazz = TestAnnotation.class;
			Method m1 = clazz.getMethod("show");
			MyAnnotation[] mas =	m1.getAnnotationsByType(MyAnnotation.class);

			for(MyAnnotation ma : mas) {
				System.out.println(ma.value());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@MyAnnotation("hello")
	@MyAnnotation("world")
	public void show() {

	}
}
