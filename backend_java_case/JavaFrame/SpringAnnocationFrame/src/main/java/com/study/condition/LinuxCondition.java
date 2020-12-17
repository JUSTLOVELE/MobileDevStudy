package com.study.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * �Ƿ���linuxϵͳ
 * @author Administrator
 *
 */
public class LinuxCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//1.�ܻ�ȡiocʹ�õ�beanfactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//2.��ȡ�������
		ClassLoader classLoader = context.getClassLoader();
		//3.��ȡ��ǰ������Ϣ
		Environment environment = context.getEnvironment();
		//4.��ȡ��bean�����ע����Ϣ
		BeanDefinitionRegistry registry = context.getRegistry();
		
		String property = environment.getProperty("os.name");
		
		if(property.contains("Linux")) {
			return true;
		}
		
		return false;
	}

}
