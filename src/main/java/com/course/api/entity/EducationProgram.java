package com.course.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EDUCATION_PROGRAM")
public class EducationProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_edu", nullable = false)
    private Integer idEdu;

    @Basic
    @Column(name = "edu_name", nullable = true, length = 30)
    private String eduName;

    @Basic
    @Column(name = "image", nullable = true, length = 30)
    private String image;


    public EducationProgram() {
    }

    public EducationProgram(String eduName, String image) {
        this.eduName = eduName;
        this.image = image;
    }

    public Integer getIdEdu() {
        return idEdu;
    }

    public void setIdEdu(Integer idEdu) {
        this.idEdu = idEdu;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
