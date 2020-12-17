package com.study.condition;

import com.study.bean.Rain;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ImportRegister implements ImportBeanDefinitionRegistrar{

	/**
	 * AnnotationMetadata:��ǰ���ע����Ϣ
	 * BeanDefinitionRegistry:�����ע����
	 * 	��������Ҫ��ӵ������е�bean:
	 * 		����BeanDefinitionRegistry.registerBeanDefinitions
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		boolean deRed = registry.containsBeanDefinition("com.study.bean.Red");
		boolean deBlue = registry.containsBeanDefinition("com.study.bean.Blue");
		
		if(deBlue && deRed) {
			//ָ��Bean������Ϣ
			RootBeanDefinition r = new RootBeanDefinition(Rain.class);
			//ָ��Bean��
			registry.registerBeanDefinition("rainBow", r);
		}
	}

}
