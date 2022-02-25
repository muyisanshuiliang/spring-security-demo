package com.example.dss.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;
    private boolean isRedirect;

    public LoginAuthenticationSuccessHandler(String url) {
        this(url, false);
    }

    public LoginAuthenticationSuccessHandler(String url, boolean isRedirect) {
        this.url = url;
        this.isRedirect = isRedirect;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println(authentication.getPrincipal());
        if (isRedirect) {
            // 请求重定向
            response.sendRedirect(url);
        } else {

            // 请求转发
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
