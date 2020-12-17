package com.study.config;

import com.study.bean.Color;
import com.study.bean.ColorFactoryBean;
import com.study.bean.Person;
import com.study.bean.Red;
import com.study.condition.ImportRegister;
import com.study.condition.LinuxCondition;
import com.study.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

//���㵱ǰ����,��������õ�bean������Ч
@Conditional({WindowsCondition.class})
@Configuration
//���ٵ������
@Import({Color.class,Red.class,MyImportSelector.class,ImportRegister.class})
public class MainConfig2 {
	
	/**
	 * ��������ע�������
	 * 1.��ɨ��+�����עע��(@Controller/@Service/@Repository/@Component)
	 * 2.@Bean[����ĵ���������������]
	 * 3.@Import[���ٸ������е���һ�����],idĬ����ȫ����
	 * 4.ImportSelector:������Ҫ����������ȫ����������;
	 * 5.ImportBeanDefinitionRegistrar
	 * 6.ʹ��spring�ṩ��FactoryBean(����Bean)
	 * @return
	 */
	
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
	
	@Bean("linus")
	@Conditional({LinuxCondition.class})
	public Person person02() {
		
		return new Person("linus", 72);
	}
	
	/**
	 * @Conditional({Condition}):����һ�������������ж�,����������������ע��bean
	 * ���ϵͳ��windows,��������ע��("bill")
	 * ���ϵͳ��linux,��������ע��linus
	 */
	@Conditional({WindowsCondition.class})
	@Bean("bill")
	public Person person01() {
		
		return new Person("Bill Gates", 62);
	}
	
	/**
	 * ������:
	 * 	�Ե�ʵ��bean����,������������ʱ�򲻴�������,��һ��ʹ��(��ȡ)Bean��������,�����г�ʼ��
	 * @return
	 */
	@Lazy
	@Bean
	public Person lazyPerson() {
		
		System.out.println("�����������person");
		return new Person("����", 25);
	}

	/**
	 * Ĭ���ǵ�ʵ����
	 * @Scope : ���������ڷ�Χ
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE : prototype:��ʵ��
	 * 			IOC��������������ȥ���÷�������������������У�ÿ�λ�ȡ��ʱ��Ż���÷�����������
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON : singleton:��ʵ����Ĭ��ֵ��
	 * 			IOC������������÷�����������ŵ�IOC������,�Ժ�ÿ�λ�ȡ����ֱ�Ӵ������л�ȡ
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST : request
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION : session
	 *
	 * @return
	 */
	@Scope("prototype")
	@Bean("person")
	public Person person() {
		
		System.out.println("�����������person");
		return new Person("����", 25);
	}
}
