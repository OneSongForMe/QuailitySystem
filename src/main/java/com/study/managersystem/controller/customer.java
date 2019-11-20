package com.study.managersystem.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.study.managersystem.entity.Comment;
import com.study.managersystem.entity.Customer;
import com.study.managersystem.entity.Good;
import com.study.managersystem.entity.Production;
import com.study.managersystem.service.CommentServiceImpl;
import com.study.managersystem.service.CustomerServiceImpl;
import com.study.managersystem.service.GoodServiceImpl;
import com.study.managersystem.service.ProductionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private GoodServiceImpl goodService;

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
        Customer customer=new Customer();
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

    @RequestMapping("orderbyshoper")
    @ResponseBody
    public List<Good> orderbyshoper(HttpSession session){
        List<Good> goods = null;
        String shoper = (String)session.getAttribute("loginer");
        goods =goodService.selectByShoper(shoper);
        return goods;
    }

    @RequestMapping("orderbyC")
    @ResponseBody
    public List<Good> orderbycustomer(HttpSession session){
        List<Good> goods = null;
        String shoper = (String)session.getAttribute("loginer");
        goods =goodService.selectByCustomer(shoper);
        return goods;
    }

    @RequestMapping("getgoods")
    public String getgoods(int pid ,HttpSession session){
        Production production=new Production();
        production=productionService.getone(pid);
        session.setAttribute("goods",production);
        return "buygoods";
    }

    @RequestMapping("gid")
    @ResponseBody
    public String getgoods(HttpSession session){
        String result=null;
        Production production=new Production();
        production=(Production) session.getAttribute("goods");
        String customer=(String)session.getAttribute("loginer");
        if(customer!=null){
            result=JSON.toJSONString(production);
        }
        return result;
    }

    @RequestMapping("buyG")
    public String buygoods(HttpSession session,Production production){
        System.out.println(production.getPid());
        Good good=new Good();
        String result=null;
        String customer=(String)session.getAttribute("loginer");
        if(customer!=null){
            good.setCustomer(customer);
            good.setDate(new Date());
            good.setShoper(production.getShoper());
            good.setProduction(production.getName());
            result=goodService.insert(good);

        }
        if("success".equals(result)){
            result="index";
        }else{
            result="getgoods?pid="+production.getPid();
        }
        return result;
    }



}
