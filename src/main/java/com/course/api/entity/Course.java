package com.course.api.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course", nullable = false)
    private Integer idCourse;

    @Basic
    @Column(name = "course", nullable = true, length = 30)
    private String course;

    @Basic
    @Column(name = "duration", nullable = true, length = 15)
    private String duration;

    @Basic
    @Column(name = "day_start", nullable = true)
    private String dayStart;

    @Basic
    @Column(name = "fee", nullable = true)
    private int fee;

    @Basic
    @Column(name = "sale", nullable = true)
    private String sale;

    @Basic
    @Column(name = "space", nullable = true)
    private String space;

    @Basic
    @Column(name = "conditions", nullable = true)
    private String conditions;

    @Basic
    @Column(name = "describes", nullable = true)
    private String describes;

    @Basic
    @Column(name = "status_course", nullable = true, length = 1)
    private int status;

    @Basic
    @Column(name = "image", nullable = true, length = 30)
    private String image;

    @Basic
    @Column(name = "CREATED_BY", nullable = true, length = 8)
    private Integer createdBy;

    @Basic
    @Column(name = "MODIFY_BY", nullable = true)
    private Integer modifyBy;

    @Basic
    @Column(name = "CREATED_DATE", nullable = true, length = 8)
    private Date createdDate;

    @Basic
    @Column(name = "MODIFY_DATE", nullable = true)
    private Date modifyDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_level")
    private Level level;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_course")
    private List<Lesson> lessons;

    public Course() {
    }

    public Course(String course, String duration, String dayStart, int fee, String sale, String space, String conditions, String describes, int status, String image, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate, Level level, List<Lesson> lessons) {
        this.course = course;
        this.duration = duration;
        this.dayStart = dayStart;
        this.fee = fee;
        this.sale = sale;
        this.space = space;
        this.conditions = conditions;
        this.describes = describes;
        this.status = status;
        this.image = image;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.level = level;
        this.lessons = lessons;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
