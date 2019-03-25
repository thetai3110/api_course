package com.course.api.dto;

import java.util.Date;

public class ClassDayDTO {

    private Integer idClass;
    private Integer idSchoolDay;
    private Integer idCa;

    public ClassDayDTO() {
    }

    public ClassDayDTO(Integer idClass, Integer idSchoolDay, Integer idCa) {
        this.idClass = idClass;
        this.idSchoolDay = idSchoolDay;
        this.idCa = idCa;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public Integer getIdSchoolDay() {
        return idSchoolDay;
    }

    public void setIdSchoolDay(Integer idSchoolDay) {
        this.idSchoolDay = idSchoolDay;
    }

    public Integer getIdCa() {
        return idCa;
    }

    public void setIdCa(Integer idCa) {
        this.idCa = idCa;
    }
}
