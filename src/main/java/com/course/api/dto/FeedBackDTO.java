package com.course.api.dto;

import javax.persistence.*;
import java.util.Date;

public class FeedBackDTO {

    private String studentName;
    private String content;
    private Date time;
    private Integer status;
    private Integer rate;
    private Integer idCourse;

    public FeedBackDTO() {
    }

    public FeedBackDTO(String studentName, String content, Date time, Integer status, Integer rate, Integer idCourse) {
        this.studentName = studentName;
        this.content = content;
        this.time = time;
        this.status = status;
        this.rate = rate;
        this.idCourse = idCourse;
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

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }
}
