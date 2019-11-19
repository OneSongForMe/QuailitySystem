package com.study.managersystem.service;

import com.study.managersystem.dao.ICommentDao;
import com.study.managersystem.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl {

    @Autowired
    ICommentDao iCommentDao;


    public List<Comment> selectAll(){
        List<Comment> comments = iCommentDao.selectAll();
        return comments;
    }

    public List<Comment> selectByAccount(String account){
        List<Comment> comments = iCommentDao.selectByAccount(account);
        return comments;
    }

    public List<Comment> selectByProduction(int pid){
        List<Comment> comments = iCommentDao.selectByProduction(pid);
        return comments;
    }

    public List<Comment> selectByProductionAndTop(int pid){
        List<Comment> comments = iCommentDao.selectByProductionAndTop(pid);
        return comments;
    }

    public String insertByProduction(Comment comment){
        int index = -1;
        String result = "fail";
        index = iCommentDao.insertByProduction(comment.getPid(),comment.getAccount(),comment.getComment(),comment.getPicture(),comment.getShoper(),comment.getDate());
        if(index>0){
            result = "success";
        }
        return result;
    }

    public String update(Comment comment){
        String result = null;
        int index = iCommentDao.update(comment.getCoid(),comment.getPid(),
                comment.getAccount(),comment.getComment(),comment.getPicture(),comment.getDate());
        if(index > 0){
            result = "success";
        }
        return result;
    }

    public String delete(int pid){
        String result = null;
        int index = iCommentDao.delete(pid);
        if(index > 0){
            result = "success";
        }
        return result;
    }
}
