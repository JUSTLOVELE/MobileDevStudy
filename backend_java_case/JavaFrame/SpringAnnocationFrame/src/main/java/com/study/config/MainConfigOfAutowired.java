package com.study.config;

import com.study.bean.Car;
import com.study.bean.Color;
import com.study.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * �Զ�װ��:
 * 		Spring��������ע��(DI),��ɶ�IOC�����и��������������ϵ��ֵ
 * 1)��@Autowired �Զ�ע��:
 * 		1)��Ĭ�����Ȱ����������������Ҷ�Ӧ�����
 * 		2)������ҵ������ͬ���͵����,�ٽ���ѧ��������Ϊ�����idȥ�����в��ң�app.getBean("beanName")
 * 		3)��@Qualifier("bookDao"):ָ����Ҫװ��������id
 * 		4)���Զ�װ��Ĭ��һ��Ҫ�����Ը�ֵ��,û�оͻᱨ��,����ʹ��@Autowired(required=false)
 * 		5)��@Primary : ��Spring�����Զ�װ���ʱ��,Ĭ��ʹ����ѡ��bean��
 * 				Ҳ���Լ���ʹ��@Qualifierָ����Ҫװ���bean������
 * 
 * 2)��Spring��֧��ʹ��@Resource(JSR250)��@Inject(JR330)[JAVA�淶��ע��]
 * 		@Resource:
 * 			���Ժ�@Autowiredһ��ʵ���Զ�װ�书��;Ĭ���ǰ��������������װ���
 * 			û����֧��@Primary����û��֧��@Autowired(reqiured=false)
 * 		@Inject:
 * 			��Ҫ����javax.inject�İ�,��Autowired�Ĺ���һ��,û��required=false
 * 		
 * @Autowired:Spring�����; @Resource,@Inject����java�淶
 * 
 * AutowiredAnnotationBeanPostProcessor:��������Զ�װ�书��;
 * 
 * 3)��@Autowired:�����������������������ԣ����Ǵ������л�ȡ�����б�
 * 		1)������ע�ڷ���λ�á�,@Bean+��������,�����������л�ȡ;Ĭ�ϲ�дAutowired
 * 		2)�������ڹ������ϡ���������ֻ��һ���вι�����������вι�������@Autowired����ʡ�ԣ�����λ�õ�������ǿ����Զ��������л�ȡ
 * 		3)�����ڲ���λ��
 * 4)���Զ��������Ҫʹ��Spring�����ײ��һЩ���{ApplicationContext,BeanFactory,xxx}
 * 		�Զ������ʵ��xxxAware���ڴ��������ʱ�򣬻���ýӿڹ涨�ķ���ע��������
 * 		��Spring�ײ�һЩ���ע�뵽�Զ����bean��
 * 		xxxAware������ʹ��xxxProcessor
 * 			ApplicationContextAware ==> ApplicationContextAwareProcessor
 * 
 * 
 * @author Administrator
 *
 */
@Configuration
@ComponentScan({"com.study.bean","com.study.service", "com.study.dao", "com.study.controller"})
public class MainConfigOfAutowired {
	
	/**
	 * @bean��ע�ķ������������ʱ�򣬷���������ֵ�������л�ȡ
	 * @param car
	 * @return
	 */
	@Bean
	public Color color(Car car) {
		
		Color color = new Color();
		color.setCar(car);
		
		return color;
	}

	@Bean("bookDao_v2")
	public BookDao bookDao() {
		return new BookDao("2");
	}
}
