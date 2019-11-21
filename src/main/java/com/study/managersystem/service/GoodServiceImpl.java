package com.study.managersystem.service;

import com.study.managersystem.dao.IGoodDao;
import com.study.managersystem.entity.Good;
import com.study.managersystem.entity.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl {

    @Autowired
    IGoodDao iGoodDao;

    public String insert (Good good){
        String result = null;
        int index = iGoodDao.insert(good.getProduction(),
                good.getCustomer(),good.getShoper(),good.getDate(),good.getCount());
        if(index > 0){
            result = "success";
        }
        System.out.println(index);
        return result;
    }

    public String delete(int gid){
        String result = null;

        int index = iGoodDao.delete(gid);

        if(index > 0){
            result = "success";
        }
        return result;
    }

    public List<Good> selectByShoper(String shoper){
        List<Good> goods = iGoodDao.selectByShoper(shoper);
        return goods;
    }

    public List<Good> selectByCustomer(String customer){
        List<Good> goods = iGoodDao.selectByCustomer(customer);
        return goods;
    }



}
