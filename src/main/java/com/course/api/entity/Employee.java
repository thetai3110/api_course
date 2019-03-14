package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee", nullable = false)
    private Integer idEmployee;

    @Basic
    @Column(name = "roles", nullable = true, length = 30)
    private String roles;

    @Basic
    @Column(name = "CMND", nullable = true, length = 15)
    private String CMND;

    @Basic
    @Column(name = "employee_name", nullable = true, length = 30)
    private String employeeName;

    @Basic
    @Column(name = "employee_date", nullable = true)
    private String employeeDate;

    @Basic
    @Column(name = "sex", nullable = true, length = 1)
    private int sex;

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    private String email;

    @Basic
    @Column(name = "phone", nullable = true, length = 11)
    private String phone;

    @Basic
    @Column(name = "salary", nullable = true)
    private int salary;

    @Basic
    @Column(name = "image", nullable = true, length = 30)
    private String image;

    @Basic
    @Column(name = "CREATED_BY", nullable = true, length = 8)
    private Integer createdBy;

    @Basic
    @Column(name = "MODIFY_BY", nullable = true)
    private Integer modifyBy;

    @Basic
    @Column(name = "CREATED_DATE", nullable = true, length = 8)
    private Date createdDate;

    @Basic
    @Column(name = "MODIFY_DATE", nullable = true)
    private Date modifyDate;

    @OneToOne
    @JoinColumn(name = "id_account")
    private Account accountEmp;

    public Employee() {
    }

    public Employee(String roles, String CMND, String employeeName, String employeeDate, int sex, String address, String email, String phone, int salary, String image, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate, Account accountEmp) {
        this.roles = roles;
        this.CMND = CMND;
        this.employeeName = employeeName;
        this.employeeDate = employeeDate;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.image = image;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.accountEmp = accountEmp;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDate() {
        return employeeDate;
    }

    public void setEmployeeDate(String employeeDate) {
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Account getAccountEmp() {
        return accountEmp;
    }

    public void setAccountEmp(Account accountEmp) {
        this.accountEmp = accountEmp;
    }
}
