package com.example.dss.config.impl;

import com.example.dss.config.AuthorityPermit;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class MyAuthorityPermit implements AuthorityPermit {
    @Override
    public boolean hasAuthority(HttpServletRequest request, Authentication authentication) {
        return false;
    }
}
