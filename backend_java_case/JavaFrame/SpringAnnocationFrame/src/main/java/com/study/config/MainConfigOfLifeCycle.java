package com.study.config;

import com.study.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean����������
 * 			bean����----��ʼ��----���ٵĹ���
 * ��������bean����������
 * ���ǿ����Զ����ʼ�������ٷ���:������bean���е���ǰ�������ڵ�ʱ�������������Զ���ĳ�ʼ�������ٵķ���
 * 
 * ����(���󴴽�)
 * 		��ʵ��: ������������ʱ�򴴽�����
 * 		��ʵ��:��ÿ�λ�ȡ��ʱ�򴴽�����
 * 
 * ��ʼ��:
 * 		���󴴽����,����ֵ��,���ó�ʼ������
 *
 * ����:
 * 		�����رյ�ʱ�����
 * ���ָ����@Scope("prototype"),�Ǿ����ڻ�ȡ���car��ʱ��Ż��ʼ��,���Ҷ�ʵ����bean,���������������
 * 
 * 1)��ָ����ʼ�������ٷ���:
 * 				�����ļ�:init-method��destory-method
 * 				ע��:@Bean(initMethod="init", destroyMethod="destory")
 * 
 * 2)��ͨ����Beanʵ��InitializingBean(�����ʼ���߼�),DisposableBean(���������߼�)
 * 
 * 
 * 3)��ʹ��JSR250:
 * 			@PostConstruct: ��bean������ɲ������Ը�ֵ���,��ִ�г�ʼ��
 * 			@PreDestory: ����������bean֮ǰ֪ͨ���ǽ���������
 * 
 * 4)��BeanPostProcessor: bean�ĺ��ô�����:
 * 			��bean��ʼ��ǰ�����һЩ����
 * 			postProcessBeforeInitialization: �ڳ�ʼ��֮ǰ����
 * 			postProcessAfterInitialization: �ڳ�ʼ��֮����
 * 
 * Spring�ײ��BeanPostProcessor��ʹ�ã�
 * 		bean��ֵ,ע���������,@Autowired,��������ע�⹦��,@Async,xxx BeanPostProcessor
 *
 *
 *	@author MainConfigOfLifeCycle
 */
@ComponentScan("com.study.bean")
@Configuration
public class MainConfigOfLifeCycle {

	
	@Bean(initMethod="init", destroyMethod="destory")
	public Car car() {
		return new Car();
	}
}
