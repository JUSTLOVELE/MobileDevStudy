package com.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yangzl 2020.07.28
 */
@SpringBootApplication
public class OAuth2App {

    public static void main(String[] args) {

        SpringApplication.run(OAuth2App.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
