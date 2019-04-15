package com.course.api.service;

import com.course.api.dto.CertificateDTO;
import com.course.api.entity.Certificate;

import java.util.List;

public interface CertificateService {
    List<Certificate> getAll() throws Exception;
    List<Certificate> getCertificateByExam(Integer idExam) throws Exception;
    List<Certificate> getCertificateByStudent(Integer idStudent) throws Exception;
    Certificate getCertificateById(Integer idCer) throws Exception;
    Certificate addCertificate(CertificateDTO certificateDTO) throws Exception;
    Certificate updateCertificate(CertificateDTO certificateDTO, Integer idCer) throws Exception;
    void removeCertificate(Certificate certificate) throws Exception;
}
