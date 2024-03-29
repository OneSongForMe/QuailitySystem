package com.study.managersystem.dao;

import com.study.managersystem.entity.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface ICustomerDao {

    @Select("select * from customer")
    List<Customer> findAll();

    @Select("select * from customer where account = #{account}")
    Customer isExist(String account);

    @Insert("insert into customer (account,password,mobile,address,email,date) value(#{account},#{password},#{mobile},#{address},#{email},#{date})")
    int add(String account, String password, String mobile,String address,String email, Date date);


    @Update("UPDATE customer SET account = #{account} ,password=#{password},mobile = #{mobile},address = #{address},email = #{email},date = #{date} WHERE cid = #{cid}")
    int update(int cid,String account, String password, String mobile,String address,String email,Date date);

    @Update("UPDATE customer SET type=1 where account=#{account}")
    int beshoper(String account);

    @Delete("delete from customer where cid = #{cid}")
    int delete(int cid);

}
