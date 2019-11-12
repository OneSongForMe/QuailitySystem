package com.study.managersystem.controller;

import com.study.managersystem.entity.Customer;
import com.study.managersystem.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping("login")
@SessionAttributes("loginer")
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
    @ResponseBody
    public String register(String account,String password,String mobile){

        Customer customer = new Customer();
        customer.setAccount(account);
        customer.setPassword(password);
        customer.setMobile(mobile);
        customer.setDate(new Date());

        boolean register = customerService.register(customer);
        if(register){
            return "success";
        }
        return "fail";
    }



    @RequestMapping("login")
    public String login(String account, String password, Model model){

        Customer customer = new Customer();
        customer.setAccount("zs");
        customer.setPassword("123");

        boolean islogin = customerService.login(customer);
        if(islogin){
            model.addAttribute("loginer",account);
            return "index";
        }else{
            return "login";
        }

    }

    @RequestMapping("isExist")
    @ResponseBody
    public String isExist(String account){
        String result = customerService.isExist(account);
        return result;

    }


    @RequestMapping("loginer")
    @ResponseBody
    public String loginer(ModelMap modelMap){
        String account = (String)modelMap.get("loginer");
        return account;
    }


}
