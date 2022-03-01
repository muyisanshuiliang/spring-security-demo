package com.example.dss.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessDenyHandler implements AccessDeniedHandler {

    private String url;
    private boolean isRedirect;

    public AccessDenyHandler(String url) {
        this(url, false);
    }

    public AccessDenyHandler(String url, boolean isRedirect) {
        this.url = url;
        this.isRedirect = isRedirect;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (isRedirect) {
            // 响应重定向
            response.sendRedirect(url);
        } else {
            // 请求转发
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
