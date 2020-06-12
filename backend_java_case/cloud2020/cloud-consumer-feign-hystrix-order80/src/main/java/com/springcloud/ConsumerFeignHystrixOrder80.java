package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerFeignHystrixOrder80
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConsumerFeignHystrixOrder80.class);
    }
}
