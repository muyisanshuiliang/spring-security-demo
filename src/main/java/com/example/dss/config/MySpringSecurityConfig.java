package com.example.dss.config;

import com.example.dss.handler.LoginAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new SimplePasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
//                .loginProcessingUrl("/do-login");// 登录逻辑请求地址
//                .successForwardUrl("/auth/main");
//                .defaultSuccessUrl("/auth/main");
                .successHandler(new LoginAuthenticationSuccessHandler("/auth/main", true))
//                .failureHandler(new LoginAuthenticationFailHandler("/auth/error"));
                .failureUrl("/login-failed");

        http.authorizeRequests()
                .antMatchers("/auth/**").authenticated()
                .anyRequest().permitAll();
        http.csrf().disable();
    }
}
