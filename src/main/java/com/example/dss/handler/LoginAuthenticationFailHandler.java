package com.example.dss.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthenticationFailHandler implements AuthenticationFailureHandler {

    private String url;
    private boolean isRedirect;

    public LoginAuthenticationFailHandler(String url) {
        this(url, false);
    }

    public LoginAuthenticationFailHandler(String url, boolean isRedirect) {
        this.url = url;
        this.isRedirect = isRedirect;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        System.out.println(exception.getMessage());
        if (isRedirect) {
            // 请求重定向
            response.sendRedirect(url);
        } else {

            // 请求转发
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
