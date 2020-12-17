package com.spring.ch_03.study_01;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jndi.JndiObjectFactoryBean;

public class DataSourceTest {
	
	@Bean
	public DataSource dataSource_Jndi(){
		
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/myDs");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return (DataSource) jndiObjectFactoryBean.getObject();
	}
}
