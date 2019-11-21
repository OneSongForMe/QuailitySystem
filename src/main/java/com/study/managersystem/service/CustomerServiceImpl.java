package com.study.managersystem.service;

import com.study.managersystem.dao.ICustomerDao;
import com.study.managersystem.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl {

    @Autowired
    private ICustomerDao iCustomerDao;

    public String isExist(String account){
        Customer customer = iCustomerDao.isExist(account);
        String result = "is not isExist";
        if(customer!=null){
            result = "isExist";
        }
        customer = null;
        return result;
    }

    public boolean login(Customer customer){

        String account = customer.getAccount();//用户名
        String password = customer.getPassword();//密码

        Customer anotherCustomer = iCustomerDao.isExist(account);//检测用户名存在数据库中

        if(customer!=null&&anotherCustomer!=null){//存在，返回数据库中的用户对象
            if (password.equals(anotherCustomer.getPassword())){//传入的密码是否与数据库中密码一致
                return true;
            }
        }
        return false;
    }

    public boolean register(Customer customer){//注册
        String account = customer.getAccount();//用户名
        String password = customer.getPassword();//密码
        String mobile = customer.getMobile();//手机号
        Date date = customer.getDate();//注册时间

        int index = -1;

        Customer anotherCustomer = iCustomerDao.isExist(account);//检测这个用户名是否已存在数据库中
        if(anotherCustomer == null){//数据库中不存在这个用户名的记录，所以可以注册
            if(customer!=null){
                index = iCustomerDao.add(account,password,mobile,customer.getAddress(),customer.getEmail(),date);//插入成功返回1，否则返回-1
                if(index > 0){//插入成功
                    return true;
                }
            }
        }

        return false;
    }


    public String update(Customer customer){
        String result = null;
        int index = iCustomerDao.update(customer.getCid(),customer.getAccount(),
                customer.getPassword(),customer.getMobile(),customer.getAddress(),customer.getEmail(),customer.getDate());
        if(index > 0){
            result = "success";
        }
        System.out.println(index);
        return result;
    }


    public String delete(int cid){
        String result = null;
        int index = iCustomerDao.delete(cid);
        if(index > 0){
            result = "success";
        }
        return result;
    }


    public String insert(Customer customer){
        String result = null;
        int index = iCustomerDao.add(customer.getAccount(),customer.getPassword(),customer.getMobile(),customer.getAddress(),customer.getEmail(),customer.getDate());
        if(index > 0){
            result = "success";
        }
        return result;
    }

    public Customer getone(String name){
        Customer customer = null;
        customer=iCustomerDao.isExist(name);
        return customer;
    }

    public List<Customer> selectAll(){
        List<Customer> customers = iCustomerDao.findAll();
        return  customers;
    }

    public int beshoper(String name){
        int s;
        s=iCustomerDao.beshoper(name);
        return s;
    }

    public Customer isshoper(String account){
        Customer customer = iCustomerDao.isExist(account);
        return customer;
    }

}
