package com.study.ext;

import com.study.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ��չԭ��:
 * 	BeanPostProcessor: bean���ô�����,bean���������ʼ����������ع�����
 *  BeanFactoryPostProcessor:beanFactory�ĺ��ô�������
 *  	��BeanFactory��׼��ʼ��֮�����:���е�bean�����Ѿ����浽beanFactory
 *  
 *  1)��ioc������������
 *  2)��invokeBeanFactoryPostProcessors(beanFactory);ִ��BeanFactoryPostProcessor
 *  	����ҵ����е�BeanFactoryPostProcessor��ִ�еķ���:
 *  		1)��ֱ����BeanFactory���ҵ�����������BeanFactoryPostProcessor�����,��ִ�����ǵķ���
 *  		2)���ڳ�ʼ�������������ǰ��ִ��
 *  	
 * @author Administrator
 * 
 * 3.ApplicationListener:���������з������¼�,�¼�����ģ�Ϳ���
 * 	public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
 *		����ApplicationEvent������������¼�:
 *
 * ԭ��
 * 		1����ioc��������
 * 		2����refresh()-��invokeBeanFactoryPostProcessors(beanFactory);
 * 		3�����������л�ȡ�����е�BeanDefinitionRegistryPostProcessor�����
 * 			1�����δ������е�postProcessBeanDefinitionRegistry()����
 * 			2����������postProcessBeanFactory()����BeanFactoryPostProcessor��
 * 
 * 		4�����������������ҵ�BeanFactoryPostProcessor�����Ȼ�����δ���postProcessBeanFactory()����
 * 	
 * 3��ApplicationListener�����������з������¼����¼�����ģ�Ϳ�����
 * 	  public interface ApplicationListener<E extends ApplicationEvent>
 * 		���� ApplicationEvent ������������¼���
 * 
 * 	 ���裺
 * 		1����дһ����������ApplicationListenerʵ���ࣩ������ĳ���¼���ApplicationEvent�������ࣩ
 * 			@EventListener;
 * 			ԭ��ʹ��EventListenerMethodProcessor�����������������ϵ�@EventListener��
 * 
 * 		2�����Ѽ��������뵽������
 * 		3����ֻҪ������������¼��ķ��������Ǿ��ܼ���������¼���
 * 				ContextRefreshedEvent������ˢ����ɣ�����bean����ȫ�������ᷢ������¼���
 * 				ContextClosedEvent���ر������ᷢ������¼���
 * 		4��������һ���¼���
 * 				applicationContext.publishEvent()��
 * 	
 *  ԭ��
 *  	ContextRefreshedEvent��IOCTest_Ext$1[source=�ҷ�����ʱ��]��ContextClosedEvent��
 *  1����ContextRefreshedEvent�¼���
 *  	1����������������refresh()��
 *  	2����finishRefresh();����ˢ����ɻᷢ��ContextRefreshedEvent�¼�
 *  2�����Լ������¼���
 *  3���������رջᷢ��ContextClosedEvent��
 *  
 *  ���¼��������̡���
 *  	3����publishEvent(new ContextRefreshedEvent(this));
 *  			1������ȡ�¼��Ķಥ�����ɷ�������getApplicationEventMulticaster()
 *  			2����multicastEvent�ɷ��¼���
 *  			3������ȡ�����е�ApplicationListener��
 *  				for (final ApplicationListener<?> listener : getApplicationListeners(event, type)) {
 *  				1���������Executor������֧��ʹ��Executor�����첽�ɷ���
 *  					Executor executor = getTaskExecutor();
 *  				2��������ͬ���ķ�ʽֱ��ִ��listener������invokeListener(listener, event);
 *  				 �õ�listener�ص�onApplicationEvent������
 *  
 *  ���¼��ಥ�����ɷ�������
 *  	1����������������refresh();
 *  	2����initApplicationEventMulticaster();��ʼ��ApplicationEventMulticaster��
 *  		1������ȥ����������û��id=��applicationEventMulticaster���������
 *  		2�������û��this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *  			���Ҽ��뵽�����У����ǾͿ������������Ҫ�ɷ��¼����Զ�ע�����applicationEventMulticaster��
 *  
 *  ������������Щ��������
 *  	1����������������refresh();
 *  	2����registerListeners();
 *  		���������õ����еļ�������������ע�ᵽapplicationEventMulticaster�У�
 *  		String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *  		//��listenerע�ᵽApplicationEventMulticaster��
 *  		getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *  		
 *   SmartInitializingSingleton ԭ��->afterSingletonsInstantiated();
 *   		1����ioc������������refresh()��
 *   		2����finishBeanFactoryInitialization(beanFactory);��ʼ��ʣ�µĵ�ʵ��bean��
 *   			1�����ȴ������еĵ�ʵ��bean��getBean();
 *   			2������ȡ���д����õĵ�ʵ��bean���ж��Ƿ���SmartInitializingSingleton���͵ģ�
 *   				����Ǿ͵���afterSingletonsInstantiated();
 */	
@ComponentScan("com.study.ext")
@Configuration
public class ExtConfig {

	@Bean
	public Blue blue() {
		return new Blue();
	}
}
