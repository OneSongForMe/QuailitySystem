package com.study.managersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
    @RequestMapping("tt")
    public String ff(){
        return "管理员管理界面";
    }
    @RequestMapping("test")
    public String test(){
        return "login";
    }
}
