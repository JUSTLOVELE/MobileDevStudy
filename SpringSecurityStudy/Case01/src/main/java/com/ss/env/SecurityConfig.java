package com.ss.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService _userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(_userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")//登录访问路径
                .defaultSuccessUrl("/test/index")//登录成功之后,跳转路径
                .permitAll()
                .and().authorizeRequests()
                .antMatchers("/", "/test/add", "/user/login").permitAll()//设置哪些路径可以直接访问
                .anyRequest().authenticated()
                .and().csrf().disable()//关闭csrf防护
        ;
    }

    @Bean
    public PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
