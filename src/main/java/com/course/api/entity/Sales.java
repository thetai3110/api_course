package com.course.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "SALES")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sales", nullable = false)
    private Integer idSales;

    @Basic
    @Column(name = "code_sale", nullable = true)
    private String code;

    @Basic
    @Column(name = "describes", nullable = true)
    private String describes;

    @Basic
    @Column(name = "status_sales", nullable = true)
    private Integer status;

    public Sales() {
    }

    public Sales(String code, String describes, Integer status) {
        this.code = code;
        this.describes = describes;
        this.status = status;
    }

    public Integer getIdSales() {
        return idSales;
    }

    public void setIdSales(Integer idSales) {
        this.idSales = idSales;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
