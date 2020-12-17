package com.spring.ch_05.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ����DispatcherServlet
 *   ��չAbstractAnnotationConfigDispatcherServletInitializer�������඼���Զ�������DispatcherServlet��SpringӦ��������,
 * SpringӦ�������Ļ�λ��Ӧ�ó����Servlet������֮��
 *   �������DispatcherServlet����,����������web.xmlΨһ����������ֻ�ܲ��쵽֧��servlet3.0�ķ������в�����������,��Tomcat7����߰汾
 * @author Administrator
 *
 */
public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * ���صĴ���@Configurationע����ཫ����������ContextLoaderListener������Ӧ���������е�bean
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{RootConfig.class};
	}

	/**
	 * ָ��������
	 *   ��DispatcherServlet������ʱ��,���ᴴ��SpringӦ��������,�����������ļ�������������������bean
	 * ������Spring WebӦ����,ͨ������������һ��Ӧ��������,�������Ӧ������������ContextLoaderListener������
	 * ʵ����AbstractAnnotationConfigDispatcherServletInitializer��ͬʱ����DispatcherServlet,ContextLoaderListener
	 *   ���صĴ���@Configurationע����ཫ����������DispatcherServletӦ���������е�bean
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class};
	}

	/**
	 * ��DispatcherServletӳ�䵽/,���ʾ������Ӧ�õ�Ĭ��Servlet,���ᴦ�����Ӧ�õ���������
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"}; 
	}

}
