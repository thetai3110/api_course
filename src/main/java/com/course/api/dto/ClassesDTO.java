package com.course.api.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

public class ClassesDTO {

    private Integer idRoom;
    private Integer idLecturers;
    private Integer idCourse;
    private String className;
    private int size;
    private int minsize;
    private int maxsize;
    private int status;

    public ClassesDTO() {
    }

    public ClassesDTO(Integer idRoom, Integer idLecturers, Integer idCourse, String className, int size, int minsize, int maxsize, int status) {
        this.idRoom = idRoom;
        this.idLecturers = idLecturers;
        this.idCourse = idCourse;
        this.className = className;
        this.size = size;
        this.minsize = minsize;
        this.maxsize = maxsize;
        this.status = status;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getIdLecturers() {
        return idLecturers;
    }

    public void setIdLecturers(Integer idLecturers) {
        this.idLecturers = idLecturers;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMinsize() {
        return minsize;
    }

    public void setMinsize(int minsize) {
        this.minsize = minsize;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
