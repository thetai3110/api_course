package com.course.api.dto;

import java.util.Date;

public class InvoiceDTO {

    private Integer idInvoice;
    private Date dateInvoice;
    private Integer cost;
    private String payment;
    private Integer idStudent;
    private Integer idCourse;
    private Integer idEmployee;
    private String email;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Integer idInvoice, Date dateInvoice, Integer cost, String payment, Integer idStudent, Integer idCourse, Integer idEmployee, String email) {
        this.idInvoice = idInvoice;
        this.dateInvoice = dateInvoice;
        this.cost = cost;
        this.payment = payment;
        this.idStudent = idStudent;
        this.idCourse = idCourse;
        this.idEmployee = idEmployee;
        this.email = email;
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
}
