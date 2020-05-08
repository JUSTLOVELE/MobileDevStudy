package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
	//http://localhost:7002/
	//http://eureka7002.com:7002
	public static void main(String[] args) {
		SpringApplication.run(EurekaMain7002.class, args);
	}
}
