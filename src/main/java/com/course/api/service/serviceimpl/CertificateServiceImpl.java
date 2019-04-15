package com.course.api.service.serviceimpl;

import com.course.api.dto.CertificateDTO;
import com.course.api.entity.Certificate;
import com.course.api.entity.Exam;
import com.course.api.entity.Student;
import com.course.api.repository.CertificateRepository;
import com.course.api.repository.ExamRepository;
import com.course.api.repository.MarksRepository;
import com.course.api.repository.StudentRepositoty;
import com.course.api.service.CertificateService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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

    @Autowired
    private StudentRepositoty studentRepositoty;

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private ExamRepository examRepository;

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
    public Certificate addCertificate(CertificateDTO certificateDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<CertificateDTO, Certificate>() {
            @Override
            protected void configure() {
                skip().setIdCertificate(null);
            }
        });
        Certificate certificate = modelMapper.map(certificateDTO, Certificate.class);
        certificate.setExam(examRepository.findExamByIdExam(certificateDTO.getIdExam()));
        certificate.setStudent((studentRepositoty.findStudentByIdStudent(certificateDTO.getIdStudent())));
        certificate.setMarks(marksRepository.findMarksByIdMarks(certificateDTO.getIdMarks()));
        certificate.setCreatedDate(new Date());
        certificate.setModifyDate(new Date());
        certificateRepository.save(certificate);
        return certificate;
    }

    @Override
    public Certificate updateCertificate(CertificateDTO certificateDTO, Integer idCer) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<CertificateDTO, Certificate>() {
            @Override
            protected void configure() {
                skip().setIdCertificate(null);
            }
        });
        Certificate certificate = modelMapper.map(certificateDTO, Certificate.class);
        certificate.setIdCertificate(idCer);
        certificate.setExam(examRepository.findExamByIdExam(certificateDTO.getIdExam()));
        certificate.setStudent((studentRepositoty.findStudentByIdStudent(certificateDTO.getIdStudent())));
        certificate.setMarks(marksRepository.findMarksByIdMarks(certificateDTO.getIdMarks()));
        certificate.setModifyDate(new Date());
        certificateRepository.save(certificate);
        return certificate;
    }

    @Override
    public void removeCertificate(Certificate certificate) {
        certificateRepository.delete(certificate);
    }
}
