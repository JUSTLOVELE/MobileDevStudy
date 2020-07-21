package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9001
{
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentMain9001.class, args);
    }
}
