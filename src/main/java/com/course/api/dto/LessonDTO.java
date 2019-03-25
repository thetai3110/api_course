package com.course.api.dto;

public class LessonDTO {

    private Integer idCourse;
    private String days;
    private String formality;
    private String title;
    private String content;

    public LessonDTO() {
    }

    public LessonDTO(Integer idCourse, String days, String formality, String title, String content) {
        this.idCourse = idCourse;
        this.days = days;
        this.formality = formality;
        this.title = title;
        this.content = content;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getFormality() {
        return formality;
    }

    public void setFormality(String formality) {
        this.formality = formality;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
