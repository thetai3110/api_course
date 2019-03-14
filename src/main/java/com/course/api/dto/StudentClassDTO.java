package com.course.api.dto;

public class StudentClassDTO {

    private Integer idClass;
    private String name;
    private String cmnd;
    private String date;
    private Integer sex;
    private String address;
    private String email;
    private String phone;
    private String job;

    public StudentClassDTO() {
    }

    public StudentClassDTO(Integer idClass, String name, String cmnd, String date, Integer sex, String address, String email, String phone, String job) {
        this.idClass = idClass;
        this.name = name;
        this.cmnd = cmnd;
        this.date = date;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.job = job;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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
