package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MAJORS")
public class Majors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_majors", nullable = false)
    private Integer idMajors;

    @Basic
    @Column(name = "majors", nullable = true, length = 30)
    private String majors;

    @Basic
    @Column(name = "describes", nullable = true)
    private String describes;

    public Majors() {
    }

    public Majors(String majors, String describes) {
        this.majors = majors;
        this.describes = describes;
    }

    public Integer getIdMajors() {
        return idMajors;
    }

    public void setIdMajors(Integer idMajors) {
        this.idMajors = idMajors;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

}
