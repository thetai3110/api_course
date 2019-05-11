package com.course.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FEEDBACK")
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feedback", nullable = false)
    private Integer idFeedBack;

    @Basic
    @Column(name = "student_name", nullable = true)
    private String studentName;

    @Basic
    @Column(name = "content", nullable = true)
    private String content;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "time_feedback", nullable = true)
    private Date time;

    @Basic
    @Column(name = "status_feedback", nullable = true)
    private Integer status;

    @Basic
    @Column(name = "rate", nullable = true)
    private Integer rate;


    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    public FeedBack() {
    }

    public FeedBack(String studentName, String content, Date time, Integer status, Integer rate, Course course) {
        this.studentName = studentName;
        this.content = content;
        this.time = time;
        this.status = status;
        this.rate = rate;
        this.course = course;
    }

    public Integer getIdFeedBack() {
        return idFeedBack;
    }

    public void setIdFeedBack(Integer idFeedBack) {
        this.idFeedBack = idFeedBack;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
