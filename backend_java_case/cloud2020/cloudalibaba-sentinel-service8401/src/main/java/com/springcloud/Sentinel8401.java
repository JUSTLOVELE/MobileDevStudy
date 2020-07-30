package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangzl 2020.07.30
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Sentinel8401 {

    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401.class, args);
    }
}
