package com.study.managersystem.controller;

import com.study.managersystem.entity.Customer;
import com.study.managersystem.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
//@SessionAttributes("loginer")
public class login {


    @Autowired
    private CustomerServiceImpl customerService;



    @RequestMapping("adminLoginHtml")
    public String adminLoginHtml(){

        return "adminLogin";
    }

    @RequestMapping("loginHtml")
    public String loginHtml(){

        return "login";
    }

    @RequestMapping("registerHtml")
    public String registerHtml(){

        return "register";
    }




    @RequestMapping("register")
    public String register(String account,String password,String email,String phone,String address){

        Customer customer = new Customer();//上面的信息封装到这个用户对象中
        customer.setAccount(account);
        customer.setPassword(password);
        customer.setMobile(phone);
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setDate(new Date());

        boolean register = customerService.register(customer);//调用函数完成注册
        if(register){//返回为真
            return "login";//去登录页面
        }
        return "registerC";//返回注册页面
    }



    @RequestMapping("login")
    public String login(String account, String password, HttpSession httpSession, HttpServletResponse response){

        if(httpSession.getAttribute("loginer")!=null){
            //从session上获取名为“loginer的对象”，如果该对象存在，则说明已登录，直接前往主页
            return "index";//前往主页

        }else{
            Customer customer = new Customer();//用户对象
            customer.setAccount(account);//从登录界面获取的用户名放入用户对象里
            customer.setPassword(password);

            boolean islogin = customerService.login(customer);
            if(islogin){
                //model.addAttribute("loginer",account);
                httpSession.setAttribute("loginer",account);//把用户名放入session上
                Cookie cookie = new Cookie("account",account);//生成存放用户名的cookie（缓存），用于自动登录
                cookie.setMaxAge(10);//设置cookie能存在10秒
                response.addCookie(cookie);//把cookie放到响应上
                return "index";//登陆成功，进入主页
            }else{
                return "login";//返回登陆界面成功登录
            }
        }


    }

    @RequestMapping("oneself")
    public String  oneself(){return "houtai";}

    @RequestMapping("isExist")
    @ResponseBody
    public String isExist(String account){
        String result = customerService.isExist(account);
        return result;

    }


    @RequestMapping("loginer")
    @ResponseBody
    public String loginer(HttpSession httpSession){
        String account = (String)httpSession.getAttribute("loginer");
        return account;
    }

    @RequestMapping("offLine")
    public String offLine(HttpSession session){
        session.removeAttribute("loginer");
        return "index";
    }




}
