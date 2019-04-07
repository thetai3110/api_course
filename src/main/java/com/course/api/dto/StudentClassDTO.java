package com.course.api.dto;

import java.util.Date;

public class StudentClassDTO {

    private Integer idClass;
    private String studentName;
    private String cmnd;
    private Date studentDate;
    private Integer sex;
    private String address;
    private String email;
    private String phone;
    private String job;
    private Integer isLogin;
    private Integer idStudent;

    public StudentClassDTO() {
    }

    public StudentClassDTO(Integer idClass, String studentName, String cmnd, Date studentDate, Integer sex, String address, String email, String phone, String job, Integer isLogin, Integer idStudent) {
        this.idClass = idClass;
        this.studentName = studentName;
        this.cmnd = cmnd;
        this.studentDate = studentDate;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.job = job;
        this.isLogin = isLogin;
        this.idStudent = idStudent;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public Integer getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }
}
