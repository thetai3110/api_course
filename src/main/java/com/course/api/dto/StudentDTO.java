package com.course.api.dto;

import java.util.Date;

public class StudentDTO {

    private Integer idAccount;
    private String studentName;
    private String job;
    private String cmnd;
    private Date studentDate;
    private int sex;
    private String address;
    private String email;
    private String phone;
    private String image;
    private int numOfRegister;

    public StudentDTO() {
    }

    public StudentDTO(Integer idAccount, String studentName, String job, String cmnd, Date studentDate, int sex, String address, String email, String phone, String image, int numOfRegister) {
        this.idAccount = idAccount;
        this.studentName = studentName;
        this.job = job;
        this.cmnd = cmnd;
        this.studentDate = studentDate;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.numOfRegister = numOfRegister;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Date getStudentDate() {
        return studentDate;
    }

    public void setStudentDate(Date studentDate) {
        this.studentDate = studentDate;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNumOfRegister() {
        return numOfRegister;
    }

    public void setNumOfRegister(int numOfRegister) {
        this.numOfRegister = numOfRegister;
    }
}
