package com.course.api.service.serviceimpl;

import com.course.api.dto.CertificateDTO;
import com.course.api.entity.Certificate;
import com.course.api.entity.Exam;
import com.course.api.entity.Marks;
import com.course.api.entity.Student;
import com.course.api.repository.CertificateRepository;
import com.course.api.repository.ExamRepository;
import com.course.api.repository.MarksRepository;
import com.course.api.repository.StudentRepositoty;
import com.course.api.service.CertificateService;
import com.course.api.service.ExamService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
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

    @Autowired
    private ExamService examService;

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
    public Certificate getCertificateByMarks(Integer idMark) {
        Certificate certificate = (Certificate) entityManager.createNativeQuery("select * from CERTIFICATE where id_marks =:idMarks",Certificate.class).setParameter("idMarks", idMark).getSingleResult();
        if(certificate != null){
            return certificate;
        }else return null;
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

    @Override
    public List<Certificate> createCertificate(List<Integer> lstId) throws Exception {
        List<Certificate> list = new ArrayList<>();
        for (Integer id:
             lstId) {
            try{
                Certificate certificate1 = getCertificateByMarks(id);
            }catch (Exception e) {
                Marks marks = marksRepository.findMarksByIdMarks(id);
                Certificate certificate = new Certificate();
                certificate.setStudent(marks.getStudent());
                certificate.setMarks(marks);
                certificate.setDateCertificate(new Date());
                certificate.setCreatedDate(new Date());
                certificate.setModifyDate(new Date());
                String classification = "";
                if (marks.getMarks() >= 5 && marks.getMarks() <= 6.5)
                    classification = "TRUNG BÌNH";
                else if (marks.getMarks() > 6.5 && marks.getMarks() <= 8)
                    classification = "KHÁ";
                else if (marks.getMarks() > 8 && marks.getMarks() <= 9.5)
                    classification = "GIỎI";
                else if (marks.getMarks() > 9.5)
                    classification = "XUẤT SẮC";
                certificate.setClassification(classification);
                certificate.setExam(examService.getExamByClass(marks.getClazz().getIdClass()));
                list.add(certificate);
                certificateRepository.save(certificate);
            }
        }
        return list;
    }
}
