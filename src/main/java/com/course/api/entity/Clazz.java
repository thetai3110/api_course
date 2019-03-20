package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CLASS")
public class Clazz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class", nullable = false)
    private Integer idClass;

    @Basic
    @Column(name = "class_name", nullable = true)
    private String className;

    @Basic
    @Column(name = "size", nullable = true)
    private int size;

    @Basic
    @Column(name = "minsize", nullable = true)
    private int minSize;

    @Basic
    @Column(name = "maxsize", nullable = true)
    private int maxSize;

    @Basic
    @Column(name = "status_class", nullable = true, length = 1)
    private int status;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_course")
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_room")
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lecturers")
    private Lecturers lecturers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_class")
    private List<ClassDay> classDays;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_class")
    private List<StudentClass> studentClasses;

    @OneToOne(mappedBy = "clazz")
    private Exam exam;

    public Clazz() {
    }

    public Clazz(String className, int size, int minSize, int maxSize, int status, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate, Course course, Room room, Lecturers lecturers, List<ClassDay> classDays, List<StudentClass> studentClasses, Exam exam) {
        this.className = className;
        this.size = size;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.status = status;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.course = course;
        this.room = room;
        this.lecturers = lecturers;
        this.classDays = classDays;
        this.studentClasses = studentClasses;
        this.exam = exam;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
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
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Lecturers getLecturers() {
        return lecturers;
    }

    public void setLecturers(Lecturers lecturers) {
        this.lecturers = lecturers;
    }

    public List<ClassDay> getClassDays() {
        return classDays;
    }

    public void setClassDays(List<ClassDay> classDays) {
        this.classDays = classDays;
    }

    public List<StudentClass> getStudentClasses() {
        return studentClasses;
    }

    public void setStudentClasses(List<StudentClass> studentClasses) {
        this.studentClasses = studentClasses;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
