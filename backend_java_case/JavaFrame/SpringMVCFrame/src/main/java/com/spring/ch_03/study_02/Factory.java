package com.spring.ch_03.study_02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ComponentScan(basePackages="com.spring.ch_03.study_02")
@Component
public class Factory {

	/**
	 * ���ø�@Conditional�������������ʵ����Condition�ӿڵ�����
	 * ���Կ�����ʵ������ӿںܼ�,ֻҪ�ṩmatches()�Ϳ�����
	 * @return
	 */
	@Bean
	@Conditional(MagicExistsCondition.class)
	public MagicBean magicBean(){
		return new MagicBean();
	}
}
