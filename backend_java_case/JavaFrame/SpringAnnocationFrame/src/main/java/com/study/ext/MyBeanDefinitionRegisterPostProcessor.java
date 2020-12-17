package com.study.ext;

import com.study.bean.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println("MyBeanDefinitionRegisterPostProcessor  postProcessBeanFactory bean������:" + beanFactory.getBeanDefinitionCount());
	}

	//BeanDefinitionRegistry bean������Ϣ�ı�������:�Ժ�BeanFactory���ǰ���BeanDefinitionRegistry���汣���ÿһ��bean������Ϣ����beanʵ��:
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		
		System.out.println("MyBeanDefinitionRegisterPostProcessor postProcessBeanDefinitionRegistry bean������:" + registry.getBeanDefinitionCount());
		//ע��һ��Bean
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
		registry.registerBeanDefinition("hello", beanDefinition);
	}

}
