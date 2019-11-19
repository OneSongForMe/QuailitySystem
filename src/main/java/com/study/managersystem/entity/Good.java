package com.study.managersystem.entity;

import java.io.Serializable;
import java.sql.Date;

public class Good implements Serializable {
    private int gid;
    private String production;
    private String customer;
    private String shoper;
    private Date date;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getShoper() {
        return shoper;
    }

    public void setShoper(String shoper) {
        this.shoper = shoper;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Good{" +
                "gid=" + gid +
                ", production='" + production + '\'' +
                ", customer='" + customer + '\'' +
                ", shoper='" + shoper + '\'' +
                ", date=" + date +
                '}';
    }
}
