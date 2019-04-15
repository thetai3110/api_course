package com.course.api.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

public class ClassesDTO {

    private Integer idRoom;
    private Integer idLecturers;
    private Integer idCourse;
    private String className;
    private Date dayStart;
    private int size;
    private int minSize;
    private int maxSize;
    private int status;

    public ClassesDTO() {
    }

    public ClassesDTO(Integer idRoom, Integer idLecturers, Integer idCourse, String className, Date dayStart, int size, int minSize, int maxSize, int status) {
        this.idRoom = idRoom;
        this.idLecturers = idLecturers;
        this.idCourse = idCourse;
        this.className = className;
        this.dayStart = dayStart;
        this.size = size;
        this.minSize = minSize;
        this.maxSize = maxSize;
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

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
