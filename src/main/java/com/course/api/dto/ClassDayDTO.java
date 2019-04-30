package com.course.api.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

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
    private Date dayStart;
    private int size;
    private int minsize;
    private int maxsize;
    private int statusClass;


    public ClassDayDTO() {
    }

    public ClassDayDTO(Integer idClassday, Integer idClass, Integer idSchoolday, Integer idCa, Integer idRoom, Integer idLecturers, Integer idCourse, String className, Date dayStart, int size, int minsize, int maxsize, int statusClass) {
        this.idClassday = idClassday;
        this.idClass = idClass;
        this.idSchoolday = idSchoolday;
        this.idCa = idCa;
        this.idRoom = idRoom;
        this.idLecturers = idLecturers;
        this.idCourse = idCourse;
        this.className = className;
        this.dayStart = dayStart;
        this.size = size;
        this.minsize = minsize;
        this.maxsize = maxsize;
        this.statusClass = statusClass;
    }

    public Integer getIdClassday() {
        return idClassday;
    }

    public void setIdClassday(Integer idClassday) {
        this.idClassday = idClassday;
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

    public void setIdSchoolday(Integer idSchoolday) {
        this.idSchoolday = idSchoolday;
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

    public int getStatusClass() {
        return statusClass;
    }

    public void setStatusClass(int statusClass) {
        this.statusClass = statusClass;
    }
}
