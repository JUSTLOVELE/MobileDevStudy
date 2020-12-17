package com.study.config;

import com.study.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * �������ͬ�������ļ�
 * includeFiltersͬexcludeFilters�෴,��д������,һ�������useDefaultFilterʹ��
 * useDefaultFilter������ɨ�����,�����Զ�ɨ��@Controller,@Service,@Repository,@Component
 * 
 * FilterType.ANNOTATION : ����ע��
 * FilterType.ASSIGNABLE_TYPE : ���ո���������
 * FilterType.ASPECTJ : ʹ��ASPECTJ���ʽ
 * FilterType.REGEX : ʹ��������ʽ
 * FilterType.CUSTOM : �Զ���,Ҫʵ����ſ���
 * @author Administrator
 *
 */
@Configuration //����spring����һ��������
/*@ComponentScan(value="com.study", excludeFilters = {
		//excludeFilters���ų��Ĺ���,��Դ���֪,�ɰ�����,ע��,����������
		//�ų�Controller,Service
		@Filter(type=FilterType.ANNOTATION, classes= {Controller.class, Service.class})
})*/
/*@ComponentScan(value="com.study", includeFilters = {
		//excludeFilters���ų��Ĺ���,��Դ���֪,�ɰ�����,ע��,����������
		//�ų�Controller,Service
		@Filter(type=FilterType.ANNOTATION, classes= {Controller.class, Service.class})
}, useDefaultFilters=false)*/
@ComponentScan(value="com.study", includeFilters = {
		/*@Filter(type=FilterType.ANNOTATION, classes= {Controller.class, Service.class}),
		@Filter(type=FilterType.ASSIGNABLE_TYPE, classes= {BookService.class}),*/
		@Filter(type=FilterType.CUSTOM, classes= {MyTypeFilter.class})
}, useDefaultFilters=false)
public class MainConfig {

	/**
	 * ��������ע��һ��bean;����Ϊ����ֵ������
	 * id��Ĭ���÷�������Ϊid
	 * Ҳ����ͨ��ָ��bean��value��ָ��
	 * @return
	 */
	@Bean
	//@Bean("person")
	public Person person() {
		return new Person("lisi", 20);
	}
}
