package com.study.managersystem.entity;

import java.io.Serializable;

public class Admin implements Serializable {

    private int aid;
    private String account;
    private String password;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
