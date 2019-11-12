package com.study.managersystem.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private int coid;
    private int pid;
    private String account;
    private String comment;
    private int istop;
    private int iscustomer;
    private Date date;

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

    public int getIstop() {
        return istop;
    }

    public void setIstop(int istop) {
        this.istop = istop;
    }

    public int getIscustomer() {
        return iscustomer;
    }

    public void setIscustomer(int iscustomer) {
        this.iscustomer = iscustomer;
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
                ", istop=" + istop +
                ", iscustomer=" + iscustomer +
                ", date=" + date +
                '}';
    }
}
