package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EXAM")
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exam", nullable = false)
    private Integer idExam;

    @Basic
    @Column(name = "day_exam", nullable = true)
    private String dayExam;

    @Basic
    @Column(name = "time_exam", nullable = true, length = 15)
    private String timeExam;

    @Basic
    @Column(name = "duration", nullable = true, length = 10)
    private String duration;

    @Basic
    @Column(name = "status_exam", nullable = true, length = 1)
    private int status;

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
    @JoinColumn(name = "id_class")
    private Clazz clazz;

    public Exam() {
    }

    public Exam(String dayExam, String timeExam, String duration, int status, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate, Clazz clazz) {
        this.dayExam = dayExam;
        this.timeExam = timeExam;
        this.duration = duration;
        this.status = status;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.clazz = clazz;
    }

    public Integer getIdExam() {
        return idExam;
    }

    public void setIdExam(Integer idExam) {
        this.idExam = idExam;
    }

    public String getDayExam() {
        return dayExam;
    }

    public void setDayExam(String dayExam) {
        this.dayExam = dayExam;
    }

    public String getTimeExam() {
        return timeExam;
    }

    public void setTimeExam(String timeExam) {
        this.timeExam = timeExam;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}
