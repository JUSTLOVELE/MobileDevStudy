package com.study.config;

import com.study.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * ʹ��@PropertySource��ȡ�ⲿ�����ļ��е�k/v���浽���еĻ���������;
 * �������ⲿ�������ļ��Ժ�ʹ��${}ȡ�������ļ�
 * @author Administrator
 *
 */
@PropertySource(value= {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

	@Bean
	public Person person() {
		return new Person();
	}
}
