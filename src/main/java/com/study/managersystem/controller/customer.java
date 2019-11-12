package com.study.managersystem.controller;

import com.study.managersystem.entity.Customer;
import com.study.managersystem.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("customer")
public class customer {

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping("selectAll")
    @ResponseBody
    public List<Customer> selectAll(){
        List<Customer> customers = null;
        customers = customerService.selectAll();
        return customers;

    }

    @RequestMapping("index")
    public  String index(){
        return "manager_Customer";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(int cid){

        String result = customerService.delete(cid);
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(@RequestBody Customer customer){
        System.out.println(customer);
        String result = null;
        result = customerService.update(customer);
        return result;
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(@RequestBody Customer customer){
        String result = null;
        customer.setDate(new Date());
        result = customerService.insert(customer);
        return result;
    }



}
