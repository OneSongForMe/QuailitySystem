package com.study.managersystem.entity;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private int cid;
    private String account;//用户名
    private String password;//密码
    private String email;//邮箱
    private String mobile;//手机号
    private String address;//地址
    private int type;//是不是商家

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private Date date;

    public Customer() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", date=" + date +
                '}';
    }
}
