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
                // 默认参数是username password
                .passwordParameter("passwd")
                .usernameParameter("user")
//                .loginProcessingUrl("/do-login");// 登录逻辑请求地址
//                .successForwardUrl("/auth/main");
//                .defaultSuccessUrl("/auth/main");
                .successHandler(new LoginAuthenticationSuccessHandler("/auth/main", true))
//                .failureHandler(new LoginAuthenticationFailHandler("/auth/error"));
                .failureUrl("/login-failed");

        /**
         * 匹配路径后授予的权限，匹配逻辑成立后再授予访问权限
         *
         * 常用的匹配请求路径方法，按照定义顺序依次执行，任何方法匹配，返回，后续逻辑不执行
         * antMatchers - 常用，基于 *【0-n个字符不包含斜线】、/*、/**【0-n个字符且包含斜线】等匹配类型，定义的表达式
         * regexMatchers - 推荐使用，效率相对较高
         * anyRequest - 相当于 /** 任意的请求
         *
         *
         * 权限：
         * permitAll - 免登陆访问
         * anonymous - 登陆之后不可访问
         * authenticated - 登陆之后可访问
         * denyAll - 任意用户任意状态都不可访问
         * fullyAuthenticated - 完整登陆后可以访问
         * rememberMe - 记住我，自动登陆|n天免密
         *
         * 底层通用方法 access()，可以实现任何权限逻辑
         * 1、定值表达式：access(“permitAll”) == permitAll()
         * 2、动态表达式
         */

        http.authorizeRequests()
                .antMatchers("/login").access("anonymous")
                .antMatchers("/register","/index").permitAll()
                .anyRequest().fullyAuthenticated();
        http.csrf().disable();
    }
}
