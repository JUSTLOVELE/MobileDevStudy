package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344
{
    //要先去hosts配置 127.0.0.1 config-3344.com
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigCenterMain3344.class);
    }
}
