package com.spring.ch_15.study_01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@ComponentScan(basePackages={"com.spring.ch_15.study_01"})
public class Config {
	
	@Bean
	public SimpleJaxWsServiceExporter jaxWsExporter(){
		
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8888/services/");
		return exporter;
	}

	@Bean
	public JaxWsPortProxyFactoryBean spitterService(){
		JaxWsPortProxyFactoryBean proxy =new JaxWsPortProxyFactoryBean();
		return proxy;
	}

}
