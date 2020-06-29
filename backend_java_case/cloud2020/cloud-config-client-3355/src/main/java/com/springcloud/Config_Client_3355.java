package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Config_Client_3355 {

    public static void main(String[] args) {
        SpringApplication.run(Config_Client_3355.class);
    }
}
