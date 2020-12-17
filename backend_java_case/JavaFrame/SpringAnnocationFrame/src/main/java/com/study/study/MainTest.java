package com.study.study;

import com.study.bean.Person;
import com.study.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	
	/**
	 * ����������ʵ��������
	 */
	@Test
	public void configTest() {
		
		ApplicationContext app = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = (Person) app.getBean("person");
		System.out.println(bean);
		System.out.println(app.getBean(Person.class));
		//��ȡspring id
		String[] namesForType = app.getBeanNamesForType(Person.class);
		
		for(String name : namesForType) {
			//�ı�id�ķ���������,��һ���Ǹı䷽����,�ڶ�������beanע����ָ��valueֵ
			System.out.println(name);
		}
	}

	/**
	 * ��ͳ�ķ�ʽ�������ļ�ʵ����bean
	 */
	@Test
	public void traditionSpring() {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person bean = (Person) app.getBean("person");
		System.out.println(bean);
	}
}
