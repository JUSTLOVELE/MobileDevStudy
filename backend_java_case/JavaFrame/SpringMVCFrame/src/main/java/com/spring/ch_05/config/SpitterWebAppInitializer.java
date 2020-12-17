package com.spring.ch_05.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 配置DispatcherServlet
 *   扩展AbstractAnnotationConfigDispatcherServletInitializer的任意类都会自动地配置DispatcherServlet和Spring应用上下文,
 * Spring应用上下文会位于应用程序的Servlet上下文之中
 *   基于类的DispatcherServlet配置,而不是配置web.xml唯一问题在于它只能不熟到支持servlet3.0的服务器中才能正常工作,如Tomcat7或更高版本
 * @author Administrator
 *
 */
public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 返回的带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的bean
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{RootConfig.class};
	}

	/**
	 * 指定配置类
	 *   当DispatcherServlet启动的时候,它会创建Spring应用上下文,并加载配置文件或配置类中所声明的bean
	 * 但是在Spring Web应用中,通常还会有另外一个应用上下文,另外这个应用上下文是由ContextLoaderListener创建的
	 * 实际上AbstractAnnotationConfigDispatcherServletInitializer会同时创建DispatcherServlet,ContextLoaderListener
	 *   返回的带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的bean
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class};
	}

	/**
	 * 将DispatcherServlet映射到/,这表示它会是应用的默认Servlet,它会处理进入应用的所有请求
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"}; 
	}

}
