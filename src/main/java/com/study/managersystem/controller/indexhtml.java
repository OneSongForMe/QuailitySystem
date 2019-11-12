package com.study.managersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("index")
public class indexhtml {




    @RequestMapping("index")
    public String helloWorld(){
        return "index";
    }


}
