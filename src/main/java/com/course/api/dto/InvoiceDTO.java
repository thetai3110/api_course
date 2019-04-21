package com.course.api.dto;

import java.util.Date;

public class InvoiceDTO {

    private Integer idInvoice;
    private Date dateInvoice;
    private Integer cost;
    private String payment;
    private String studentName;
    private Integer idClass;
    private Integer idEmployee;
    private Integer groupNum;
    private String email;
    private Integer idRegister;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Integer idInvoice, Date dateInvoice, Integer cost, String payment, String studentName, Integer idClass, Integer idEmployee, Integer groupNum, String email, Integer idRegister) {
        this.idInvoice = idInvoice;
        this.dateInvoice = dateInvoice;
        this.cost = cost;
        this.payment = payment;
        this.studentName = studentName;
        this.idClass = idClass;
        this.idEmployee = idEmployee;
        this.groupNum = groupNum;
        this.email = email;
        this.idRegister = idRegister;
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Date getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(Integer idRegister) {
        this.idRegister = idRegister;
    }
}
