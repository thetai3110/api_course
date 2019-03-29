package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CLASS_DAY")
public class ClassDay implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classday", nullable = false)
    private Integer idClassDay;

    @Basic
    @Column(name = "id_class", nullable = true)
    private Integer idClass;

    @Basic
    @Column(name = "CREATED_BY", nullable = true)
    private Integer createdBy;

    @Basic
    @Column(name = "MODIFY_BY", nullable = true)
    private Integer modifyBy;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = true)
    private Date createdDate;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFY_DATE", nullable = true)
    private Date modifyDate;

    @ManyToOne
    @JoinColumn(name = "id_schoolday")
    private SchoolDay schoolDay;

    @ManyToOne
    @JoinColumn(name = "id_ca")
    private Ca ca;

    public ClassDay() {
    }

    public ClassDay(Integer idClass, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate, SchoolDay schoolDay, Ca ca) {
        this.idClass = idClass;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.schoolDay = schoolDay;
        this.ca = ca;
    }

    public Integer getIdClassDay() {
        return idClassDay;
    }

    public void setIdClassDay(Integer idClassDay) {
        this.idClassDay = idClassDay;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
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

    public SchoolDay getSchoolDay() {
        return schoolDay;
    }

    public void setSchoolDay(SchoolDay schoolDay) {
        this.schoolDay = schoolDay;
    }

    public Ca getCa() {
        return ca;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }
}
