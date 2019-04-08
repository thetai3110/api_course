package com.course.api.service.serviceimpl;

import com.course.api.dto.StudentDTO;
import com.course.api.entity.Account;
import com.course.api.entity.Student;
import com.course.api.entity.StudentClass;
import com.course.api.repository.AccountRepositoty;
import com.course.api.repository.StudentClassRepository;
import com.course.api.repository.StudentRepositoty;
import com.course.api.service.AccountService;
import com.course.api.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepositoty studentRepositoty;

    @Autowired
    private AccountRepositoty accountRepositoty;

    @Autowired
    private AccountService accountService;

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
    public Student getStudentByEmail(String email) throws Exception {
        return studentRepositoty.findStudentByEmail(email);
    }

    @Override
    public Student addStudent(StudentDTO studentDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<StudentDTO, Student>() {
            @Override
            protected void configure() {
                skip().setIdStudent(null);
            }
        });
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setAccountStu(accountRepositoty.findAccountByIdAccount(studentDTO.getIdAccount()));
        student.setCreatedDate(new Date());
        student.setModifyDate(new Date());
        studentRepositoty.save(student);
        return student;
    }

    @Override
    public Student updateStudent(StudentDTO studentDTO, Integer idStudent) {
        ModelMapper modelMapper = new ModelMapper();
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setIdStudent(idStudent);
        student.setAccountStu(accountRepositoty.findAccountByIdAccount(studentDTO.getIdAccount()));
        student.setModifyDate(new Date());
        studentRepositoty.save(student);
        return student;
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
        Account account = new Account();
        if(student.getAccountStu() != null){
            account = student.getAccountStu();
            studentRepositoty.delete(student);
            accountService.removeAccount(account);
        }else{
            studentRepositoty.delete(student);
        }

    }
}
