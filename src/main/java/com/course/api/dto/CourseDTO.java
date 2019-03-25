package com.course.api.dto;

import java.util.Date;

public class CourseDTO {

    private Integer idCourse;
    private Integer idLevel;
    private String course;
    private String duration;
    private Date dayStart;
    private int fee;
    private String sale;
    private String space;
    private String conditions;
    private String describes;
    private int status;
    private String image;

    public CourseDTO() {
    }

    public CourseDTO(Integer idCourse, Integer idLevel, String course, String duration, Date dayStart, int fee, String sale, String space, String conditions, String describes, int status, String image) {
        this.idCourse = idCourse;
        this.idLevel = idLevel;
        this.course = course;
        this.duration = duration;
        this.dayStart = dayStart;
        this.fee = fee;
        this.sale = sale;
        this.space = space;
        this.conditions = conditions;
        this.describes = describes;
        this.status = status;
        this.image = image;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public Integer getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(Integer idLevel) {
        this.idLevel = idLevel;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
