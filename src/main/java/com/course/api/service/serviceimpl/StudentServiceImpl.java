package com.course.api.service.serviceimpl;

import com.course.api.dto.InfoStudentDTO;
import com.course.api.dto.StudentDTO;
import com.course.api.entity.*;
import com.course.api.repository.StudentClassRepository;
import com.course.api.repository.StudentRepositoty;
import com.course.api.service.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepositoty studentRepositoty;

    @Autowired
    private MarksService marksService;

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @Autowired
    private CertificateService certificateService;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAll() {
        return studentRepositoty.findAll();
    }

    @Override
    public Student getStudentById(Integer idStu) throws Exception {
        return studentRepositoty.findStudentByIdStudent(idStu);
    }

    @Override
    public Student gettudentByAccount(Integer idAccount) {
        String query = "SELECT * FROM STUDENT WHERE id_account =:idAccount";
        try {
            Student student = (Student) entityManager.createNativeQuery(query, Student.class).setParameter("idAccount", idAccount).getSingleResult();
            return student;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Student getStudentByUsername(String username) {
        String query = "SELECT * FROM STUDENT join ACCOUNTS on STUDENT.id_account = ACCOUNTS.id_account where ACCOUNTS.username =:username";
        return (Student) entityManager.createNativeQuery(query,Student.class).setParameter("username", username).getSingleResult();
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepositoty.findStudentByStudentName(name);
    }

    @Override
    public Student getStudentByCMND(String CMND) {
        return studentRepositoty.findStudentByCmnd(CMND);
    }

    @Override
    public List<Student> getStudentByCMNDAndName(String CMND, String name) {
        return entityManager.createNativeQuery("select * from STUDENT st where st.student_name =:studentName and st.cmnd =:cmnd", Student.class)
                .setParameter("studentName", name).setParameter("cmnd", CMND).getResultList();
    }

    @Override
    public List<InfoStudentDTO> getInfoStudent(String name, String cmnd) {
        String query = "SELECT * FROM CLASS join STUDENT_CLASS on CLASS.id_class = STUDENT_CLASS.id_class join COURSE on CLASS.id_course = COURSE.id_course join LEVELCOURSE on COURSE.id_level = LEVELCOURSE.id_level join STUDENT on STUDENT_CLASS.id_student = STUDENT.id_student WHERE STUDENT.student_name =:studentName and STUDENT.cmnd =:cmnd";
        return entityManager.createNativeQuery(query, InfoStudentDTO.class).setParameter("studentName", name).setParameter("cmnd", cmnd).getResultList();
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepositoty.findStudentByEmail(email);
    }

    @Override
    public List<Student> getStudentByInvoice(Integer idInvoice) {
        return entityManager.createNativeQuery("select * from STUDENT st join INVOICE_DETAIL inv on st.id_student = inv.id_student where inv.id_invoice =:idInvoice",Student.class).setParameter("idInvoice",idInvoice).getResultList();
    }

    @Override
    public Student addStudent(Student student) {
        student.setCreatedDate(new Date());
        student.setModifyDate(new Date());
        studentRepositoty.save(student);
        return student;
    }

    @Override
    public List<Student> addMultiStudent(List<StudentDTO> studentDTOS) {
        List<Student> students = new ArrayList<>();
        for (StudentDTO studentDTO:
             studentDTOS) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<StudentDTO, Student>() {
                @Override
                protected void configure() {
                    skip().setIdStudent(null);
                }
            });
            Student student = modelMapper.map(studentDTO, Student.class);
            students.add(addStudent(student));
        }
        if(students.size() == studentDTOS.size()){
            return students;
        }else{
            return null;
        }
    }

    @Override
    public Student updateStudent(Student student) {
        student.setModifyDate(new Date());
        studentRepositoty.save(student);
        return student;
    }

    @Override
    public void removeStudent(Student student) throws Exception {
        if(!studentClassRepository.findStudentClassByIdStudent(student.getIdStudent()).isEmpty()){
            for (StudentClass stu:
                    studentClassRepository.findStudentClassByIdStudent(student.getIdStudent())) {
                studentClassRepository.delete(stu);
            }
        }
        if(invoiceDetailService.getInvoiceDetailByStudent(student.getIdStudent()) != null){
            invoiceDetailService.removeInvoice(invoiceDetailService.getInvoiceDetailByStudent(student.getIdStudent()));
        }
        if(!certificateService.getCertificateByStudent(student.getIdStudent()).isEmpty()){
            for (Certificate cer:
                    certificateService.getCertificateByStudent(student.getIdStudent())) {
                certificateService.removeCertificate(cer);
            }
        }
        if(!marksService.getMarksByStudent(student.getIdStudent()).isEmpty()){
            for (Marks marks:
                    marksService.getMarksByStudent(student.getIdStudent())) {
                marksService.removeMarks(marks);
            }
        }
        studentRepositoty.delete(student);
    }
}
