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

        Customer customer = new Customer();
        customer.setAccount(account);
        customer.setPassword(password);
        customer.setMobile(phone);
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setDate(new Date());

        boolean register = customerService.register(customer);
        if(register){
            return "login";
        }
        return "registerC";
    }



    @RequestMapping("login")
    public String login(String account, String password, HttpSession httpSession, HttpServletResponse response){

        if(httpSession.getAttribute("loginer")!=null){
            return "index";

        }else{
            Customer customer = new Customer();
            customer.setAccount(account);
            customer.setPassword(password);

            boolean islogin = customerService.login(customer);
            if(islogin){
                //model.addAttribute("loginer",account);
                httpSession.setAttribute("loginer",account);
                Cookie cookie = new Cookie("account",account);
                cookie.setMaxAge(10);
                response.addCookie(cookie);
                return "index";
            }else{
                return "login";
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
