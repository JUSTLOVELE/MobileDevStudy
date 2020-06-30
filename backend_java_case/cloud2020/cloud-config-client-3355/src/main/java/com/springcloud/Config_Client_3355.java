package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 如果github的配置改变了,不重启这个3355的服务配置是不会更新的,必须要手动发送一个Post请求才会更新
 * curl -X POST "http://localhost:3355/actuator/refresh"
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class Config_Client_3355 {

    public static void main(String[] args) {
        SpringApplication.run(Config_Client_3355.class);
    }
}
