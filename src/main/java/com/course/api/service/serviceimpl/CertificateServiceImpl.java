package com.course.api.service.serviceimpl;

import com.course.api.entity.Certificate;
import com.course.api.entity.Exam;
import com.course.api.entity.Student;
import com.course.api.repository.CertificateRepository;
import com.course.api.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("certificateService")
public class CertificateServiceImpl implements CertificateService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public List<Certificate> getAll() {
        return certificateRepository.findAll();
    }

    @Override
    public List<Certificate> getCertificateByExam(Integer idExam) {
        String query = "SELECT * FROM CERTIFICATE WHERE id_exam =:idExam";
        return entityManager.createNativeQuery(query,Certificate.class).setParameter("idLevel",idExam).getResultList();
    }

    @Override
    public List<Certificate> getCertificateByStudent(Integer idStudent) {
        String query = "SELECT * FROM CERTIFICATE WHERE id_student =:idStudent";
        return entityManager.createNativeQuery(query,Certificate.class).setParameter("idStudent",idStudent).getResultList();
    }


    @Override
    public Certificate getCertificateById(Integer idCer) {
        return certificateRepository.findCertificateByIdCertificate(idCer);
    }

    @Override
    public Certificate addCertificate(Certificate certificate) {
        certificate.setCreatedDate(new Date());
        certificate.setModifyDate(new Date());
        certificateRepository.save(certificate);
        return certificate;
    }

    @Override
    public Certificate updateCertificate(Certificate certificate) {
        certificate.setModifyDate(new Date());
        certificateRepository.save(certificate);
        return certificate;
    }

    @Override
    public void removeCertificate(Certificate certificate) {
        certificateRepository.delete(certificate);
    }
}
