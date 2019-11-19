package com.study.managersystem.dao;

import com.study.managersystem.entity.Good;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface IGoodDao {

    @Insert("insert into good " +
            "(production,customer,shoper,date) " +
            "value(#{production},#{customer},#{shoper},#{date})")
    int insert(String production, String customer, String shoper, Date date);

    @Select("select * from good where shoper = #{shoper}")
    List<Good> selectByShoper(String shoper);

    @Delete("delete * from good where gid = #{gid}")
    int delete(int gid);


}
