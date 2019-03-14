package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MAJORS")
public class Majors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_majors", nullable = false)
    private Integer idMajors;

    @Basic
    @Column(name = "majors", nullable = true, length = 30)
    private String majors;

    @Basic
    @Column(name = "describes", nullable = true)
    private String describes;

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

    public Majors() {
    }

    public Majors(String majors, String describes, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate) {
        this.majors = majors;
        this.describes = describes;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
    }

    public Integer getIdMajors() {
        return idMajors;
    }

    public void setIdMajors(Integer idMajors) {
        this.idMajors = idMajors;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
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
}
