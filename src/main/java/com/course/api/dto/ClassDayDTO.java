package com.course.api.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClassDayDTO {

    @Id
    private Integer idClassday;
    private Integer idClass;
    private Integer idSchoolday;
    private Integer idCa;
    private Integer idRoom;
    private Integer idLecturers;
    private Integer idCourse;
    private String className;
    private int size;
    private int minsize;
    private int maxsize;
    private int statusClass;


    public ClassDayDTO() {
    }

    public ClassDayDTO(Integer idClassDay, Integer idClass, Integer idSchoolDay, Integer idCa, Integer idRoom, Integer idLecturers, Integer idCourse, String className, int size, int minSize, int maxSize, int status) {
        this.idClassday = idClassDay;
        this.idClass = idClass;
        this.idSchoolday = idSchoolDay;
        this.idCa = idCa;
        this.idRoom = idRoom;
        this.idLecturers = idLecturers;
        this.idCourse = idCourse;
        this.className = className;
        this.size = size;
        this.minsize = minSize;
        this.maxsize = maxSize;
        this.statusClass = status;
    }

    public Integer getIdClassDay() {
        return idClassday;
    }

    public void setIdClassDay(Integer idClassDay) {
        this.idClassday = idClassDay;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public Integer getIdSchoolday() {
        return idSchoolday;
    }

    public void setIdSchoolday(Integer idSchoolDay) {
        this.idSchoolday = idSchoolDay;
    }

    public Integer getIdCa() {
        return idCa;
    }

    public void setIdCa(Integer idCa) {
        this.idCa = idCa;
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

    public int getMinSize() {
        return minsize;
    }

    public void setMinSize(int minSize) {
        this.minsize = minSize;
    }

    public int getMaxSize() {
        return maxsize;
    }

    public void setMaxSize(int maxSize) {
        this.maxsize = maxSize;
    }

    public int getStatus() {
        return statusClass;
    }

    public void setStatus(int status) {
        this.statusClass = status;
    }
}
