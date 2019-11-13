package com.study.managersystem.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private int coid;
    private int pid;
    private String account;
    private String comment;
    private String picture;
    private Date date;


    public Comment() {
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "coid=" + coid +
                ", pid=" + pid +
                ", account='" + account + '\'' +
                ", comment='" + comment + '\'' +
                ", picture='" + picture + '\'' +
                ", date=" + date +
                '}';
    }
}
