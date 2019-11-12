package com.study.managersystem.controller;

import com.study.managersystem.entity.Production;
import com.study.managersystem.service.ProductionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("production")
public class product {

    @Autowired
    ProductionServiceImpl productionService;


    @RequestMapping("index")
    public String index(){
        return "manager_production";
    }

    @RequestMapping("selectByKeyword")
    @ResponseBody
    public List<Production> selectByKeyword(String keyword){
        List<Production> productionList = productionService.selectByKeyword(keyword);
        return productionList;
    }

    @RequestMapping("loadProduction")
    @ResponseBody
    public List<Production> loadProduction(){
        List<Production> productionList = productionService.loadProduction();
        return productionList;
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(@RequestBody Production production){
        String result = productionService.insert(production);
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(@RequestBody Production production){
        String result = productionService.update(production);
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(int pid){
        String result = productionService.delete(pid);
        return result;
    }
}
