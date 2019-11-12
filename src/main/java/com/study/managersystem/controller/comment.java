package com.study.managersystem.controller;

import com.study.managersystem.dao.ICommentDao;
import com.study.managersystem.entity.Comment;
import com.study.managersystem.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("comment")
public class comment {


    @Autowired
    CommentServiceImpl commentService;


    @RequestMapping("index")
    public String index(){

        return "manager_Comment";
    }


    @RequestMapping("selectAll")
    @ResponseBody
    public List<Comment> selectAll(){

        List<Comment> comments = commentService.selectAll();
        return comments;
    }

    @RequestMapping("selectByProduction")
    @ResponseBody
    public List<Comment> selectByProduction(int pid){

        List<Comment> comments = commentService.selectByProduction(pid);
        return comments;
    }

    @RequestMapping("selectByProductionAndTop")
    @ResponseBody
    public List<Comment> selectByProductionAndTop(int pid){

        List<Comment> comments = commentService.selectByProductionAndTop(pid);
        return comments;
    }

    @RequestMapping("insertComment")
    @ResponseBody
    public String insertByProduction(String pid,String mycomment){

        System.out.println(pid);
        Comment comment = new Comment();
        comment.setPid(Integer.parseInt(pid));
        comment.setAccount("zs");
        comment.setComment(mycomment);
        comment.setIscustomer(0);
        comment.setIstop(0);
        comment.setDate(new Date());
        String result = commentService.insertByProduction(comment);
        return result;
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(@RequestBody Comment comment){

        comment.setDate(new Date());
        String result = commentService.insertByProduction(comment);
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(@RequestBody Comment comment){


        String result = commentService.update(comment);
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(int coid){


        String result = commentService.delete(coid);
        return result;
    }


}
