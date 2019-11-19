package com.study.managersystem.entity;

import java.io.Serializable;
import java.util.Date;

public class Production implements Serializable {
    private int pid;
    private String name;
    private String material;
    private Date date;
    private String shoper;

    public String getShoper() {
        return shoper;
    }

    public void setShoper(String shoper) {
        this.shoper = shoper;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Production{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", date=" + date +
                ", shoper='" + shoper + '\'' +
                '}';
    }
}
