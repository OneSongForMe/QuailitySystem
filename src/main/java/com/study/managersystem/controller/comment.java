package com.study.managersystem.controller;

import com.alibaba.fastjson.JSON;
import com.study.managersystem.dao.ICommentDao;
import com.study.managersystem.entity.Comment;
import com.study.managersystem.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class comment{


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

    @RequestMapping("selectByAccount")
    @ResponseBody
    public List<Comment> selectByAccount(String account){

        List<Comment> comments = commentService.selectByAccount(account);
        return comments;
    }

    @RequestMapping("selectByProduction")
    @ResponseBody
    public List<Comment> selectByProduction(int pid){

        List<Comment> comments = commentService.selectByProduction(pid);
        return comments;
    }

    @RequestMapping("selectByshoper")
    @ResponseBody
    public String selectByshoper(HttpSession httpSession){
        String result=null;
        String account=httpSession.getAttribute("loginer").toString();
        List<Comment>comments=commentService.selectByShoper(account);
        result= JSON.toJSONString(comments);
        return result;
    }

    @RequestMapping("insertComment")
    @ResponseBody
    public String insertByProduction(String pid,String mycomment){

        System.out.println(pid);
        Comment comment = new Comment();
        comment.setPid(Integer.parseInt(pid));
        comment.setAccount("zs");
        comment.setComment(mycomment);
        //有的加图片
        comment.setDate(new Date());
        String result = commentService.insertByProduction(comment);
        return result;
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(Comment comment, HttpSession httpSession, MultipartFile multipartFile){

        comment.setAccount(httpSession.getAttribute("loginer").toString());
        System.out.println(comment);
        String parentPath = "D:/Picture/";
        String path = null;
        File dir = new File(parentPath);
        File file = null;
        if(!dir.exists()){
            dir.mkdir();
        }
        if(multipartFile != null){
            System.out.println(multipartFile.getOriginalFilename());
            file = new File(parentPath+multipartFile.getOriginalFilename());
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            path = file.getAbsolutePath();
        }
        comment.setPicture(path);
        System.out.println(path);
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
