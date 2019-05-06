package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LECTURERS")
public class Lecturers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lecturers", nullable = false)
    private Integer idLecturers;

    @Basic
    @Column(name = "lecturers_name", nullable = true, length = 30)
    private String lecturersName;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "lecturers_date", nullable = true)
    private Date lecturersDate;

    @Basic
    @Column(name = "sex", nullable = true, length = 1)
    private int sex;

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    private String email;

    @Basic
    @Column(name = "phone", nullable = true, length = 11)
    private String phone;

    @Basic
    @Column(name = "salary", nullable = true)
    private int salary;

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

    @ManyToOne
    @JoinColumn(name = "id_majors")
    private Majors majors;

    public Lecturers() {
    }

    public Lecturers(String lecturersName, Date lecturersDate, int sex, String address, String email, String phone, int salary, String image, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate, Majors majors) {
        this.lecturersName = lecturersName;
        this.lecturersDate = lecturersDate;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.image = image;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.majors = majors;
    }

    public Integer getIdLecturers() {
        return idLecturers;
    }

    public void setIdLecturers(Integer idLecturers) {
        this.idLecturers = idLecturers;
    }

    public String getLecturersName() {
        return lecturersName;
    }

    public void setLecturersName(String lecturersName) {
        this.lecturersName = lecturersName;
    }

    public Date getLecturersDate() {
        return lecturersDate;
    }

    public void setLecturersDate(Date lecturersDate) {
        this.lecturersDate = lecturersDate;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    public Majors getMajors() {
        return majors;
    }

    public void setMajors(Majors majors) {
        this.majors = majors;
    }
}
