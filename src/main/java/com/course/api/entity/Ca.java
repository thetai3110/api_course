package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CA")
public class Ca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ca", nullable = false)
    private Integer idCa;

    @Basic
    @Column(name = "time_start", nullable = true, length = 25)
    private String timeStart;

    @Basic
    @Column(name = "time_end", nullable = true, length = 25)
    private String timeEnd;

    public Ca() {
    }

    public Ca(String timeStart, String timeEnd) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Integer getIdCa() {
        return idCa;
    }

    public void setIdCa(Integer idCa) {
        this.idCa = idCa;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
