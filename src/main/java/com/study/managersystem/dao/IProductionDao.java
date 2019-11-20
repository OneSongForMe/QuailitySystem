package com.study.managersystem.dao;

import com.study.managersystem.entity.Production;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface IProductionDao {

    //查询所有产品
    @Select("select * from production")
    List<Production> loadProduction();

    //查询所有产品
    @Select("select * from production where pid=#{pid}")
    Production getgood(int pid);

    //查询所有产品
    @Select("select * from production where shoper=#{name}")
    List<Production> getmy(String name);

    //根据关键字查询产品
    @Select("select * from production where name = #{keyword}")
    List<Production> selectByKeyword(String keyword);

    @Insert("insert into production (name,material,date,shoper) value(#{name},#{material},#{date},#{shoper})")
    int addProduction(String name, String material, Date date, String shoper);

    @Update("update  production  set name=#{name},material=#{material},date=#{date} where pid = #{pid}")
    int updateProduction(int pid, String name, String material, Date date);

    @Delete("delete from production where pid = #{pid}")
    int delete(int pid);
}
