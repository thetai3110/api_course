package com.course.api.dto;

public class NewsDTO {

    private Integer idCourse;
    private String title;
    private String content;
    private String describes;
    private Integer status;
    private Integer idEmp;
    private String image;
    private String avatar;
    private Integer views;

    public NewsDTO() {
    }

    public NewsDTO(Integer idCourse, String title, String content, String describes, Integer status, Integer idEmp, String image, String avatar, Integer views) {
        this.idCourse = idCourse;
        this.title = title;
        this.content = content;
        this.describes = describes;
        this.status = status;
        this.idEmp = idEmp;
        this.image = image;
        this.avatar = avatar;
        this.views = views;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
