package com.course.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EXAM_DETAIL")
public class ExamDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exam_detail", nullable = false)
    private Integer idExamDetail;

    @Basic
    @Column(name = "id_exam", nullable = true)
    private Integer idExam;

    @Basic
    @Column(name = "id_class", nullable = true)
    private Integer idClass;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "day_exam", nullable = true)
    private Date dayExam;

    @Basic
    @Column(name = "time_exam", nullable = true, length = 15)
    private String timeExam;

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

    public ExamDetail() {
    }

    public ExamDetail(Integer idExam, Integer idClass, Date dayExam, String timeExam, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate) {
        this.idExam = idExam;
        this.idClass = idClass;
        this.dayExam = dayExam;
        this.timeExam = timeExam;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
    }

    public Integer getIdExamDetail() {
        return idExamDetail;
    }

    public void setIdExamDetail(Integer idExamDetail) {
        this.idExamDetail = idExamDetail;
    }

    public Integer getIdExam() {
        return idExam;
    }

    public void setIdExam(Integer idExam) {
        this.idExam = idExam;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public Date getDayExam() {
        return dayExam;
    }

    public void setDayExam(Date dayExam) {
        this.dayExam = dayExam;
    }

    public String getTimeExam() {
        return timeExam;
    }

    public void setTimeExam(String timeExam) {
        this.timeExam = timeExam;
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
