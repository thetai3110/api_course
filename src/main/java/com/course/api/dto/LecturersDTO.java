package com.course.api.dto;

import java.util.Date;

public class LecturersDTO {

    private String lecturersName;
    private Date lecturersDate;
    private int sex;
    private String address;
    private String email;
    private String phone;
    private int salary;
    private String image;
    private Integer idMajors;

    public LecturersDTO() {
    }

    public LecturersDTO(String lecturersName, Date lecturersDate, int sex, String address, String email, String phone, int salary, String image, Integer idMajors) {
        this.lecturersName = lecturersName;
        this.lecturersDate = lecturersDate;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.image = image;
        this.idMajors = idMajors;
    }

    public String getLecturersName() {
        return lecturersName;
    }

    public void setLecturersName(String lecturersName) {
        this.lecturersName = lecturersName;
    }

    public Date getLecturersDate() {
        return lecturersDate;
    }

    public void setLecturersDate(Date lecturersDate) {
        this.lecturersDate = lecturersDate;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIdMajors() {
        return idMajors;
    }

    public void setIdMajors(Integer idMajors) {
        this.idMajors = idMajors;
    }
}
