package com.spring.ch_03.study_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
@Configuration
@PropertySource("classpath:/com/spring/ch_03/study_03/app.properties")
public class ExpressiveConfig {

	@Autowired
	Environment env;
	
	@Bean
	public BlankDisc disc(){
		return new BlankDisc(env.getProperty("title"), env.getProperty("artist"));
	}
}
