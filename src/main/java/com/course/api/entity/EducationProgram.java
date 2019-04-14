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

    @Basic
    @Column(name = "CREATED_BY", nullable = true)
    private Integer createdBy;

    @Basic
    @Column(name = "MODIFY_BY", nullable = true)
    private Integer modifyBy;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = true)
    private Date createdDate;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFY_DATE", nullable = true)
    private Date modifyDate;

    public EducationProgram() {
    }

    public EducationProgram(String eduName, String image, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate) {
        this.eduName = eduName;
        this.image = image;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
