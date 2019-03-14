package com.course.api.service;

import com.course.api.entity.Certificate;

import java.util.List;

public interface CertificateService {
    List<Certificate> getAll() throws Exception;
    List<Certificate> getCertificateByExam(Integer idExam) throws Exception;
    List<Certificate> getCertificateByStudent(Integer idStudent) throws Exception;
    Certificate getCertificateById(Integer idCer) throws Exception;
    Certificate addCertificate(Certificate certificate) throws Exception;
    Certificate updateCertificate(Certificate certificate) throws Exception;
    void removeCertificate(Certificate certificate) throws Exception;
}
