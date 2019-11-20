package com.study.managersystem.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/loginC",filterName = "autoLogin")
public class autoLogin implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        Cookie[] cookies = request.getCookies();
        if(cookies!= null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("account")){
                    request.getSession().setAttribute("loginer",cookie.getValue());
                    request.getRequestDispatcher("/login").forward(request,response);
                }
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
