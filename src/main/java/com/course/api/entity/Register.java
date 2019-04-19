package com.course.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "REGISTER")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register", nullable = false)
    private Integer idRegister;

    @Basic
    @Column(name = "id_class", nullable = false)
    private Integer idClass;

    @Basic
    @Column(name = "name_register", nullable = true)
    private String nameRegister;

    @Basic
    @Column(name = "email", nullable = true)
    private String email;

    @Basic
    @Column(name = "phone", nullable = true)
    private String phone;

    @Basic
    @Column(name = "id_sale", nullable = true)
    private String idSale;

    @Basic
    @Column(name = "job", nullable = true)
    private String job;

    @Basic
    @Column(name = "group_num", nullable = true)
    private Integer groupNum;

    @Basic
    @Column(name = "is_fee", nullable = true)
    private Integer isFee;

    @Basic
    @Column(name = "payment", nullable = true)
    private Integer payment;

    @Basic
    @Column(name = "formula", nullable = true)
    private String formula;

    @Basic
    @Column(name = "status_register", nullable = true)
    private Integer status;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = true)
    private Date createdDate;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFY_DATE", nullable = true)
    private Date modifyDate;

    public Register() {
    }

    public Register(Integer idClass, String nameRegister, String email, String phone, String idSale, String job, Integer groupNum, Integer isFee, Integer payment, String formula, Integer status, Date createdDate, Date modifyDate) {
        this.idClass = idClass;
        this.nameRegister = nameRegister;
        this.email = email;
        this.phone = phone;
        this.idSale = idSale;
        this.job = job;
        this.groupNum = groupNum;
        this.isFee = isFee;
        this.payment = payment;
        this.formula = formula;
        this.status = status;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
    }

    public Integer getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(Integer idRegister) {
        this.idRegister = idRegister;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public String getNameRegister() {
        return nameRegister;
    }

    public void setNameRegister(String nameRegister) {
        this.nameRegister = nameRegister;
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

    public String getIdSale() {
        return idSale;
    }

    public void setIdSale(String idSale) {
        this.idSale = idSale;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public Integer getIsFee() {
        return isFee;
    }

    public void setIsFee(Integer isFee) {
        this.isFee = isFee;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
