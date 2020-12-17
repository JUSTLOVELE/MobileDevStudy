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
	 * 设置给@Conditional的类可以是任意实现了Condition接口的类型
	 * 可以看出来实现这个接口很简单,只要提供matches()就可以了
	 * @return
	 */
	@Bean
	@Conditional(MagicExistsCondition.class)
	public MagicBean magicBean(){
		return new MagicBean();
	}
}
