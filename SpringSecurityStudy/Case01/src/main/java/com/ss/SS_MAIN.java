package com.ss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yangzl 2021.03.29
 * @version 1.00.00
 * @Description:
 * @history:
 */
@SpringBootApplication
@MapperScan("com.ss.mapper")
public class SS_MAIN {
    public static void main(String[] args) {
        SpringApplication.run(SS_MAIN.class);
    }
}
