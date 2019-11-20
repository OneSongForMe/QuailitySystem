package com.study.managersystem;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = {"/loginC"},filterName = "autoLogin")
public class autoLogin implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        Cookie[] cookies = request.getCookies();
        boolean hasLogin = false;
        if(cookies!= null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("account")){
                    System.out.println("自动登录");
                    request.getSession().setAttribute("loginer",cookie.getValue());
                    System.out.println(cookie.getValue());
                    hasLogin = true;
                    break;
                }
            }
        }
        System.out.println("filter生效");
        if(hasLogin){
            request.getRequestDispatcher("login").forward(request,response);
        }else{
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
