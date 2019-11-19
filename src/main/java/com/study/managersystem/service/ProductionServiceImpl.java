package com.study.managersystem.service;

import com.study.managersystem.dao.IProductionDao;
import com.study.managersystem.entity.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductionServiceImpl {

    @Autowired
    IProductionDao iProductionDao;

    public List<Production> loadProduction(){
        List<Production> productions = iProductionDao.loadProduction();
        return productions;
    }

    public List<Production> selectByKeyword(String keyword){
        List<Production> productions = iProductionDao.selectByKeyword(keyword);
        return productions;
    }

    public String update(Production production){
        String result = null;

        int index = iProductionDao.updateProduction(production.getPid(),production.getName(),production.getMaterial(),new Date());

        if(index > 0){
            result = "success";
        }
        return result;
    }

    public String delete(int pid){
        String result = null;

        int index = iProductionDao.delete(pid);

        if(index > 0){
            result = "success";
        }
        return result;
    }

    public String insert(Production production){
        String result = null;

        int index = iProductionDao.addProduction(production.getName(),production.getMaterial(),new Date(),production.getShoper());

        if(index > 0){
            result = "success";
        }
        return result;
    }

}
