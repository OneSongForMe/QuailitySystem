package com.study.managersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class customer {
    @RequestMapping("loginC")
    public String  login(){return "login";}

    @RequestMapping("registerC")
    public String reg(){return "registerC";}

}
