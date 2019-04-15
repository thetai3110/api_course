package com.course.api.dto;

import java.util.Date;

public class CertificateDTO {

    private Date dateCertificate;
    private String classification;
    private Integer idStudent;
    private Integer idExam;
    private Integer idMarks;

    public CertificateDTO() {
    }

    public CertificateDTO(Date dateCertificate, String classification, Integer idStudent, Integer idExam, Integer idMarks) {
        this.dateCertificate = dateCertificate;
        this.classification = classification;
        this.idStudent = idStudent;
        this.idExam = idExam;
        this.idMarks = idMarks;
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

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdExam() {
        return idExam;
    }

    public void setIdExam(Integer idExam) {
        this.idExam = idExam;
    }

    public Integer getIdMarks() {
        return idMarks;
    }

    public void setIdMarks(Integer idMarks) {
        this.idMarks = idMarks;
    }
}
