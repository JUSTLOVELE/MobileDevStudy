package com.spring.ch_04.study_01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @EnableAspectJAutoProxy ����AspectJ�Զ�����
 *   ������ʹ��JavaConfig����XML,AspectJ�Զ�������Ϊʹ��@Aspectע���bean����һ������,�������
 * ��Χ�������и�������е���ƥ���bean.�����������,����ΪAopConfig bean ����һ������,Audience���е�
 * ֪ͨ����������perform()����ǰ��ִ��
 *   ������Ҫ��ס:Spring��AspectJ�Զ��������ʹ��@AspectJ��Ϊ���������ָ��,������Ȼ�ǻ��ڴ����,������
 *����Ȼ��Spring���ڴ��������,��Ϊ����ζ�ž���ʹ�õ���@AspectJע��,��������Ȼ���ڴ������ĵ���,���������
 *AspectJ����������,���Ǳ���������ʱʹ��AspectJ���Ҳ�����Spring���������ڴ��������
 *   
 * @author Administrator
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AopConfig {

	@Bean
	public Audience audience(){
		return new Audience();
	}
}
