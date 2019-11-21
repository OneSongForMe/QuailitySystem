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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
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

    @RequestMapping("customerComm")
    @ResponseBody
    public List<Comment> selectByAccount(HttpSession session){
        String account = (String)session.getAttribute("loginer");
        List<Comment> comments = commentService.selectByAccount(account);
        return comments;
    }

    @RequestMapping("selectxByProduction")
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
        comment.setPicture(multipartFile.getOriginalFilename());
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

    @RequestMapping("duserdata")
    @ResponseBody
    public List<Comment> delete(int coid, HttpSession session){
        List<Comment> comments=null;
        String result = commentService.delete(coid);
        if("success".equals(result)){
            String account = (String)session.getAttribute("loginer");
            comments = commentService.selectByAccount(account);
        }
        return comments;
    }



    @RequestMapping("getPicture")
    @ResponseBody
    public String getPicture(String picture, HttpServletResponse response){

        System.out.println(picture);

        int len;
        byte[] buf = new byte[1024];

        File file = new File("D:\\Picture\\"+picture);
        //D:\\Picture\\3ed39513b6215633e532732cb2d422d1.jpg
        if(file.exists()){
            System.out.println("存在文件");
        }else{
            System.out.println("文件不存在");
        }
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedInputStream bin = new BufferedInputStream(inputStream);
            OutputStream out = response.getOutputStream();
            while((len=bin.read(buf))!=-1){
                out.write(buf,0,len);
            }
            out.flush();
            out.close();
            bin.close();
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}
