package com.course.api.dto;

import java.util.Date;

public class EmployeeDTO {

    private Integer idAccount;
    private String roles;
    private String cmnd;
    private String employeeName;
    private Date employeeDate;
    private int sex;
    private String address;
    private String email;
    private String phone;
    private int salary;
    private String image;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer idAccount, String roles, String cmnd, String employeeName, Date employeeDate, int sex, String address, String email, String phone, int salary, String image) {
        this.idAccount = idAccount;
        this.roles = roles;
        this.cmnd = cmnd;
        this.employeeName = employeeName;
        this.employeeDate = employeeDate;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.image = image;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeDate() {
        return employeeDate;
    }

    public void setEmployeeDate(Date employeeDate) {
        this.employeeDate = employeeDate;
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
}
