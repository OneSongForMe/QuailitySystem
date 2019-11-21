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
        Cookie[] cookies = request.getCookies();//从浏览器上获取cookie缓存信息
        boolean hasLogin = false;//定义一个判断是否还在允许自动登录的时间内
        if(cookies!= null){//拿到的cookie不为空
            for (Cookie cookie : cookies) {//
                if(cookie.getName().equals("account")){//查找是否存在名字为“account”的缓存信息，如果有，就说明在自动登录的有效期里
                    System.out.println("自动登录");
                    request.getSession().setAttribute("loginer",cookie.getValue());//把获取的缓存信息中的登录信息存储在session上，名字为“loginer”
                    System.out.println(cookie.getValue());
                    hasLogin = true;
                    break;
                }
            }
        }
        System.out.println("filter生效");
        if(hasLogin){//是否还在允许自动登录的时间内
            request.getRequestDispatcher("login").forward(request,response);//跳转到登录模块
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
