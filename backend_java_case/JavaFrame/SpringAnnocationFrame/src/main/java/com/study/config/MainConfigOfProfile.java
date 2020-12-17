package com.study.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.study.bean.Blue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile:
 * 		SpringΪ�����ṩ�Ŀ��Ը��ݵ�ǰ��������̬�ļ�����л�һϵ������Ĺ���
 * �������������Ի�������������
 * ����Դ��(/A)(/B)(/C)����ͬ������ͬ������Դ
 * @Profile : ָ������������ܱ�ע�ᵽ������,��ָ���κλ�����,����ע��������
 * 
 * 1)�����˻�����ʶ��bean,ֻ����������������ʱ�����ע�ᵽ������,Ĭ����default����
 * 2)��д����������,ֻ����ָ���Ļ�����ʱ��,����������������������ò��ܿ�ʼ��Ч,�����û�б�����,����ķ�����ȻҲû�б�������
 * 3)��û�б�ע������ʶ��bean��,�κλ����¶��Ǽ��ص�;
 * 
 * 
 * @author Administrator
 *
 */
@Profile("test")
@PropertySource("classpath:/db.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware{
	
	@Value("${db.user}")
	private String user;

	private StringValueResolver resolver;
	
	private String driverClass;
	
	@Profile("dev")
	@Bean
	public Blue blue() {
		return new Blue();
	}
	
	@Bean
	@Profile("test")
	public DataSource dataSource_01(@Value("${db.password}")String pwd) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://192.168.1.2:3307/hy-crm");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	
	@Bean
	@Profile("dev")
	public DataSource dataSource_02(@Value("${db.password}")String pwd) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://192.168.1.2:3307/e_hms");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	
	@Bean
	@Profile("prod")
	public DataSource dataSource_03(@Value("${db.password}")String pwd) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://192.168.1.2:3307/hy_tea");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// TODO Auto-generated method stub
		this.resolver = resolver;
		this.driverClass = resolver.resolveStringValue("${db.driverClass}");
	}
}
