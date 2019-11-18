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

        String account = customer.getAccount();
        String password = customer.getPassword();

        Customer anotherCustomer = iCustomerDao.isExist(account);

        if(customer!=null){
            if (password.equals(anotherCustomer.getPassword())){
                return true;
            }
        }
        return false;
    }

    public boolean register(Customer customer){
        String account = customer.getAccount();
        String password = customer.getPassword();
        String mobile = customer.getMobile();
        Date date = customer.getDate();

        int index = -1;

        Customer anotherCustomer = iCustomerDao.isExist(account);
        if(customer!=null){
            index = iCustomerDao.add(account,password,mobile,customer.getAddress(),customer.getEmail(),date);
            if(index > 0){
                return true;
            }
        }
        return false;
    }


    public String update(Customer customer){
        String result = null;
        int index = iCustomerDao.update(customer.getCid(),customer.getAccount(),
                customer.getPassword(),customer.getMobile(),customer.getDate());
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


    public List<Customer> selectAll(){
        List<Customer> customers = iCustomerDao.findAll();
        return  customers;
    }

}
