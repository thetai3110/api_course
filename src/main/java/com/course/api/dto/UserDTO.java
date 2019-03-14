package com.course.api.dto;

import java.util.Date;

public class UserDTO {
    private String username;
    private String pass;
    private String name;
    private String cmnd;
    private String date;
    private String sex;
    private String address;
    private String email;
    private String phone;
    private String job;

    public UserDTO() {
    }

    public UserDTO(String username, String pass, String name, String cmnd, String date, String sex, String address, String email, String phone, String job) {
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.cmnd = cmnd;
        this.date = date;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.job = job;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
