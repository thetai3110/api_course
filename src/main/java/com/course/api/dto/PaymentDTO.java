package com.course.api.dto;

import java.util.Date;

public class PaymentDTO {

    private Integer idInvoice;
    private Date dateInvoice;
    private Integer cost;
    private String payment;
    private Integer idStudent;
    private Integer idCourse;
    private Integer idEmployee;
    private String email;
    private Integer idStudentclass;
    private Integer idClass;
    private Integer isFee;

    public PaymentDTO() {
    }

    public PaymentDTO(Integer idInvoice, Date dateInvoice, Integer cost, String payment, Integer idStudent, Integer idCourse, Integer idEmployee, String email, Integer idStudentclass, Integer idClass, Integer isFee) {
        this.idInvoice = idInvoice;
        this.dateInvoice = dateInvoice;
        this.cost = cost;
        this.payment = payment;
        this.idStudent = idStudent;
        this.idCourse = idCourse;
        this.idEmployee = idEmployee;
        this.email = email;
        this.idStudentclass = idStudentclass;
        this.idClass = idClass;
        this.isFee = isFee;
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

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdStudentclass() {
        return idStudentclass;
    }

    public void setIdStudentclass(Integer idStudentclass) {
        this.idStudentclass = idStudentclass;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public Integer getIsFee() {
        return isFee;
    }

    public void setIsFee(Integer isFee) {
        this.isFee = isFee;
    }
}
