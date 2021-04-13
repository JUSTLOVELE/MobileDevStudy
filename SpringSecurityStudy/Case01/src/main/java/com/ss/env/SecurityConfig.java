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
        //配置没有权限的默认页面
        http.exceptionHandling().accessDeniedPage("/unauth_404.html");
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")//登录访问路径
                .defaultSuccessUrl("/test/index")//登录成功之后,跳转路径
                .permitAll()
                .and().authorizeRequests()
                .antMatchers("/", "/test/add", "/user/login").permitAll()//设置哪些路径可以直接访问
                //当前的用户要有admins这个权限才能访问这个链接
                //.antMatchers("/test/index").hasAnyAuthority("admins")
                //这个可以使得多个权限访问路径
                .antMatchers("/test/index").hasAnyAuthority("admins,manager")
                .anyRequest().authenticated()
                .and().csrf().disable()//关闭csrf防护
        ;
    }

    @Bean
    public PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
