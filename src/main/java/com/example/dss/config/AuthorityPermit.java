package com.example.dss.config;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface AuthorityPermit {

    boolean hasAuthority(HttpServletRequest request, Authentication authentication);
}
