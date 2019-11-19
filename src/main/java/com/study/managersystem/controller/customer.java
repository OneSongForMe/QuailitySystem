package com.study.managersystem.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.study.managersystem.entity.Comment;
import com.study.managersystem.entity.Customer;
import com.study.managersystem.entity.Production;
import com.study.managersystem.service.CommentServiceImpl;
import com.study.managersystem.service.CustomerServiceImpl;
import com.study.managersystem.service.ProductionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.image.ImageDecoder;
import sun.awt.image.InputStreamImageSource;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
public class customer {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private ProductionServiceImpl productionService;

    @Autowired
    private CommentServiceImpl commentService;

    @RequestMapping("loginC")
    public String  login(){return "login";}

    @RequestMapping("registerC")
    public String reg(){return "registerC";}


    @RequestMapping("findone")
    @ResponseBody
    public String findone(HttpSession httpSession){
        String account = (String)httpSession.getAttribute("loginer");
        String s=null;
        Customer customer=customerService.getone(account);
        s= JSON.toJSONString(customer);
        return s;
    }

    @RequestMapping("editself")
    public String editself( Customer customer){
        System.out.println(customer);
        customer.setDate(new Date());
        String result=null;
        String ss=customerService.update(customer);
        if("success".equals(ss)){
           result="houtai";
        }
        else {
            result="index";
        }
        return result;
    }

    @RequestMapping("beshoper")
    public String shoper(HttpSession httpSession){
        String account = (String)httpSession.getAttribute("loginer");
        String result=null;
        int s=customerService.beshoper(account);
        if(s>0){
            result="houtai";
        }
        return result;
    }
    @RequestMapping("isshoper")
    @ResponseBody
    public String isshoper(HttpSession httpSession){
        String result=null;
        String account = (String)httpSession.getAttribute("loginer");
        Customer customer;
        customer=customerService.isshoper(account);
        int s=customer.getType();
        if(s==1){
            result="success";
        }
        return result;
    }

    @RequestMapping("mygoods")
    @ResponseBody
    public String mygoods(HttpSession httpSession){
        String result=null;
        String account = (String)httpSession.getAttribute("loginer");
        List<Production> productions=productionService.getmys(account);
        result=JSON.toJSONString(productions);
        return result;
    }

    @RequestMapping("selectByShoper")
    @ResponseBody
    public List<Comment> selectComment(HttpSession session){
        List<Comment> comments = null;
        String shoper = (String)session.getAttribute("loginer");
        comments =commentService.selectByShoper(shoper);
        return comments;
    }

    //增加商品
    @RequestMapping("addgoods")
    @ResponseBody
    public String addgoods(String name,String material,HttpSession httpSession){
        String result = "fail";
        if("".equals(name)||"".equals(material)){
            return  result;
        }
       Production production = new Production();
       production.setName(name);
       production.setMaterial(material);
       production.setDate(new Date());
       String shoper = (String)httpSession.getAttribute("loginer");
       production.setShoper(shoper);
       result = productionService.insert(production);
        return result;
    }



}
