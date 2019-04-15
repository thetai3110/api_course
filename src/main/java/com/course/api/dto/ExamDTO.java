package com.course.api.dto;

import java.util.Date;

public class ExamDTO {

    private Date dayExam;
    private String timeExam;
    private String duration;
    private int status;
    private Integer idClass;

    public ExamDTO() {
    }

    public ExamDTO(Date dayExam, String timeExam, String duration, int status, Integer idClass) {
        this.dayExam = dayExam;
        this.timeExam = timeExam;
        this.duration = duration;
        this.status = status;
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

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }
}
