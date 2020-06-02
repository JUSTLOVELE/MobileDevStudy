package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//CLOUD-PROVIDER-PAYMENT这个服务要用随机算法来调用
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = MyRule.class)
public class OrderMain80 {

	public static void main(String[] args) {
		SpringApplication.run(OrderMain80.class, args);
	}
}
