package com.course.api.dto;

import java.util.Date;

public class ExamDTO {

    private Date dateExam;
    private String duration;
    private int status;
    private Integer idCourse;

    public ExamDTO() {
    }

    public ExamDTO(Date dateExam, String duration, int status, Integer idCourse) {
        this.dateExam = dateExam;
        this.duration = duration;
        this.status = status;
        this.idCourse = idCourse;
    }

    public Date getDateExam() {
        return dateExam;
    }

    public void setDateExam(Date dateExam) {
        this.dateExam = dateExam;
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

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }
}
