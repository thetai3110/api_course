package com.course.api.repository;

import com.course.api.entity.Certificate;
import com.course.api.entity.Exam;
import com.course.api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    Certificate findCertificateByIdCertificate(Integer idCer);


}
