package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MARKS")
public class Marks implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marks", nullable = false)
    private Integer idMarks;

    @Basic
    @Column(name = "marks", nullable = true)
    private Float marks;

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
    @JoinColumn(name = "id_class")
    private Clazz clazz;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    public Marks() {
    }

    public Marks(Float marks, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate, Clazz clazz, Student student) {
        this.marks = marks;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.clazz = clazz;
        this.student = student;
    }

    public Integer getIdMarks() {
        return idMarks;
    }

    public void setIdMarks(Integer idMarks) {
        this.idMarks = idMarks;
    }

    public Float getMarks() {
        return marks;
    }

    public void setMarks(Float marks) {
        this.marks = marks;
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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
