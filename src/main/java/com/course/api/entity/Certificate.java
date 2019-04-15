package com.course.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CERTIFICATE")
public class Certificate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificate", nullable = false)
    private Integer idCertificate;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "date_certificate", nullable = true)
    private Date dateCertificate;

    @Basic
    @Column(name = "classification", nullable = true, length = 10)
    private String classification;

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
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_exam")
    private Exam exam;

    @OneToOne
    @JoinColumn(name = "id_marks")
    private Marks marks;

    public Certificate() {
    }

    public Certificate(Date dateCertificate, String classification, Integer createdBy, Integer modifyBy, Date createdDate, Date modifyDate, Student student, Exam exam, Marks marks) {
        this.dateCertificate = dateCertificate;
        this.classification = classification;
        this.createdBy = createdBy;
        this.modifyBy = modifyBy;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.student = student;
        this.exam = exam;
        this.marks = marks;
    }

    public Integer getIdCertificate() {
        return idCertificate;
    }

    public void setIdCertificate(Integer idCertificate) {
        this.idCertificate = idCertificate;
    }

    public Date getDateCertificate() {
        return dateCertificate;
    }

    public void setDateCertificate(Date dateCertificate) {
        this.dateCertificate = dateCertificate;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }
}
