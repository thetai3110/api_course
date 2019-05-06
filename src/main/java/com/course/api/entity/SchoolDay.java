package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SCHOOLDAY")
public class SchoolDay implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_schoolday", nullable = false)
    private Integer idSchoolDay;

    @Basic
    @Column(name = "days", nullable = true, length = 15)
    private String day;

    public SchoolDay() {
    }

    public SchoolDay(String day) {
        this.day = day;
    }

    public Integer getIdSchoolDay() {
        return idSchoolDay;
    }

    public void setIdSchoolDay(Integer idSchoolDay) {
        this.idSchoolDay = idSchoolDay;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
