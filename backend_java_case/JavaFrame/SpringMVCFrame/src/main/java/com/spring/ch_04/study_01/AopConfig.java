package com.spring.ch_04.study_01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @EnableAspectJAutoProxy 启用AspectJ自动代理
 *   不管是使用JavaConfig还是XML,AspectJ自动代理都会为使用@Aspect注解的bean创建一个代理,这个代理
 * 会围绕着所有该切面的切点锁匹配的bean.在这种情况下,将会为AopConfig bean 创建一个代理,Audience类中的
 * 通知方法将会在perform()调用前后执行
 *   我们需要记住:Spring的AspectJ自动代理仅仅使用@AspectJ作为创建切面的指导,切面依然是基于代理的,本质上
 *它依然是Spring基于代理的切面,因为这意味着尽管使用的是@AspectJ注解,但我们仍然限于代理方法的调用,如果想利用
 *AspectJ的所有能力,我们必须在运行时使用AspectJ并且不依赖Spring来创建基于代理的切面
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
