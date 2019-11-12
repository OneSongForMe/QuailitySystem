package com.study.managersystem.dao;

import com.study.managersystem.entity.Comment;
import com.study.managersystem.entity.Production;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface ICommentDao {

    @Select("select * from comment ")
    List<Comment> selectAll();

    @Select("select * from comment where pid = #{pid}")
    List<Comment> selectByProduction(int pid);

    @Select("select * from comment where pid = #{pid} and istop = 1")
    List<Comment> selectByProductionAndTop(int pid);

    @Insert("insert into comment (pid,account,comment,istop,iscustomer,date) value(#{pid},#{account},#{comment},#{istop},#{iscustomer},#{date})")
    int insertByProduction(int pid, String account, String comment, int istop, int iscustomer, Date date);

    @Update("update  comment set pid=#{pid},account=#{account},comment=#{comment},istop=#{istop},iscustomer=#{iscustomer},date=#{date} where coid = #{coid}")
    int update(int coid,int pid, String account, String comment, int istop, int iscustomer, Date date);

    @Delete("delete from comment where coid = #{coid}")
    int delete(int coid);


}
