package com.course.api.service.serviceimpl;

import com.course.api.ExportExcel.ExportListClass;
import com.course.api.dto.ClassesDTO;
import com.course.api.entity.*;
import com.course.api.repository.*;
import com.course.api.sendemail.Email;
import com.course.api.service.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("classService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClazzRepository clazzRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private LecturersRepository lecturersRepository;

    @Autowired
    private StudentClassService studentClassService;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private ClassDayService classDayService;

    @Autowired
    private ClassDayRepository classDayRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private StudentRepositoty studentRepositoty;

    @Autowired
    private MarksService marksService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Clazz> getAll() {
        return clazzRepository.findAll();
    }

    @Override
    public Clazz getClassById(Integer idClazz) {
        return clazzRepository.findClazzByIdClass(idClazz);
    }

    @Override
    public List<Clazz> getClassByCourse(Integer idCourse) {
        return entityManager.createNativeQuery("select * from CLASS where id_course =:idCourse",Clazz.class).setParameter("idCourse",idCourse).getResultList();
    }

    @Override
    public List<Clazz> getClassByCourseAndStatus(Integer idCourse, Integer status) {
        return entityManager.createNativeQuery("select * from CLASS where id_course =:idCourse and status_class =:status",Clazz.class).setParameter("idCourse",idCourse).setParameter("status", status).getResultList();
    }

    @Override
    public List<Clazz> getClassByLecturers(Integer idLec) {
        return entityManager.createNativeQuery("select * from CLASS where id_lecturers =:idLec",Clazz.class).setParameter("idLec",idLec).getResultList();
    }

    @Override
    public List<Clazz> getClassByRoom(Integer idRoom) {
        return entityManager.createNativeQuery("select * from CLASS where id_room =:idRoom",Clazz.class).setParameter("idRoom",idRoom).getResultList();
    }

    @Override
    public List<Clazz> getClassByStatus(Integer status) {
        return clazzRepository.findClazzByStatus(status);
    }

    @Override
    public Clazz addClass(ClassesDTO classesDTO){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<ClassesDTO, Clazz>() {
            @Override
            protected void configure() {
                skip().setIdClass(null);
            }
        });
        Clazz clazz = modelMapper.map(classesDTO, Clazz.class);
        clazz.setCourse(courseRepository.findCourseByIdCourse(classesDTO.getIdCourse()));
        clazz.setRoom(roomRepository.findRoomByIdRoom(classesDTO.getIdRoom()));
        clazz.setLecturers(lecturersRepository.findLecturersByIdLecturers(classesDTO.getIdLecturers()));
        clazz.setCreatedDate(new Date());
        clazz.setModifyDate(new Date());
        clazzRepository.save(clazz);
        return clazz;
    }

    @Override
    public Clazz updateClass(ClassesDTO classesDTO, Integer idClass) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<ClassesDTO, Clazz>() {
            @Override
            protected void configure() {
                skip().setIdClass(null);
            }
        });
        Clazz clazz = modelMapper.map(classesDTO, Clazz.class);
        clazz.setIdClass(idClass);
        clazz.setCourse(courseRepository.findCourseByIdCourse(classesDTO.getIdCourse()));
        clazz.setRoom(roomRepository.findRoomByIdRoom(classesDTO.getIdRoom()));
        clazz.setLecturers(lecturersRepository.findLecturersByIdLecturers(classesDTO.getIdLecturers()));
        clazz.setModifyDate(new Date());
        clazzRepository.save(clazz);
        return clazz;
    }

    @Override
    public Clazz updateClass(Clazz clazz) {
        clazz.setModifyDate(new Date());
        clazzRepository.save(clazz);
        return clazz;
    }

    @Override
    public void removeClass(Clazz clazz) throws Exception {
        if(!studentClassRepository.findStudentClassByIdClass(clazz.getIdClass()).isEmpty()){
            for (StudentClass student:
                    studentClassRepository.findStudentClassByIdClass(clazz.getIdClass())) {
                studentRepositoty.delete(studentRepositoty.findStudentByIdStudent(student.getIdStudent()));
            }
        }
        if(!classDayRepository.findClassDayByIdClass(clazz.getIdClass()).isEmpty()){
            for (ClassDay classDay:
                    classDayRepository.findClassDayByIdClass(clazz.getIdClass())) {
                classDayService.removeClassDay(classDay);
            }
        }
        if(!invoiceDetailRepository.findInvoiceDetailByIdClass(clazz.getIdClass()).isEmpty()){
            for (InvoiceDetail invoiceDetail:
                    invoiceDetailRepository.findInvoiceDetailByIdClass(clazz.getIdClass())){
                invoiceDetailRepository.delete(invoiceDetail);
           }
        }
        if(!invoiceRepository.findInvoiceByClazz(clazz).isEmpty()){
            for (Invoice invoice:
                    invoiceRepository.findInvoiceByClazz(clazz)) {
                invoiceRepository.delete(invoice);
            }
        }
        if(!marksService.getMarksByClass(clazz.getIdClass()).isEmpty()){
            for (Marks marks:
                    marksService.getMarksByClass(clazz.getIdClass())){
                marksService.removeMarks(marks);
            }
        }
        clazzRepository.delete(clazz);
    }

    @Override
    public boolean openClass(Integer id) {
        Clazz clazz = clazzRepository.findClazzByIdClass(id);
        clazz.setStatus(1);
        clazzRepository.save(clazz);
        List<StudentClass> studentClasses = studentClassRepository.findStudentClassByIdClass(id);
        for (StudentClass stu_class:
             studentClasses) {
            Marks marks = new Marks();
            Marks marks1 = null;
            try {
                 marks1 = marksService.getMarksByClassAndStudent(id, stu_class.getIdStudent());
            }catch (Exception e) {
                marks.setClazz(clazz);
                marks.setStudent(studentRepositoty.findStudentByIdStudent(stu_class.getIdStudent()));
                marks.setIdMarks(null);
                marksRepository.save(marks);
            }
        }
        if(clazz != null) return true;
        return false;
    }

    @Override
    public boolean closeClass(Integer id) {
        Clazz clazz = clazzRepository.findClazzByIdClass(id);
        clazz.setStatus(0);
        clazzRepository.save(clazz);
        if(clazz != null) return true;
        return false;
    }

    @Override
    public boolean cancelClass(Integer id) throws Exception {
        Clazz clazz = clazzRepository.findClazzByIdClass(id);
        clazz.setStatus(2);
        for (StudentClass stu_class:
                studentClassRepository.findStudentClassByIdClass(clazz.getIdClass())) {
            String email = studentRepositoty.findStudentByIdStudent(stu_class.getIdStudent()).getEmail();
            String subject = "Trung tâm tin học thông báo";
            String content = "Lớp học "+ clazz.getClassName() + " khóa học " + clazz.getCourse().getCourse() + "-" +clazz.getCourse().getLevel().getLevel() + " đã bị hủy" +
                    " vì lý do không đủ học viên để mở lớp. Chúng tôi rất xin lỗi về điểu này!";
            Email.notification(subject,content, email);
        }
        clazzRepository.save(clazz);
        if(!classDayRepository.findClassDayByIdClass(id).isEmpty()){
            for (ClassDay classDay:
                    classDayRepository.findClassDayByIdClass(clazz.getIdClass())) {
                classDayService.removeClassDay(classDay);
            }
        }
        if(clazz != null) return true;
        return false;
    }

    @Override
    public boolean finish(Integer id) throws Exception {
        Clazz clazz = clazzRepository.findClazzByIdClass(id);
        clazz.setStatus(3);
        clazzRepository.save(clazz);
        if(!classDayRepository.findClassDayByIdClass(id).isEmpty()){
            for (ClassDay classDay:
                    classDayRepository.findClassDayByIdClass(clazz.getIdClass())) {
                classDayService.removeClassDay(classDay);
            }
        }
        if(clazz != null) return true;
        return false;
    }

    @Override
    public boolean sendNotif(Integer idClass) {
        Clazz clazz = clazzRepository.findClazzByIdClass(idClass);
        clazz.setStatus(2);
        for (StudentClass stu_class:
                studentClassRepository.findStudentClassByIdClass(idClass)) {
            String email = studentRepositoty.findStudentByIdStudent(stu_class.getIdStudent()).getEmail();
            String subject = "Trung tâm tin học thông báo";
            String content = "Lớp học "+ clazz.getClassName() + " khóa học " + clazz.getCourse().getCourse() + "-" +clazz.getCourse().getLevel().getLevel() + "" +
                    " đã gần hết thời hạn đóng học phí, bạn vui lòng đóng học phí trước ngày " + clazz.getDayStart();
            Email.notification(subject,content, email);
        }
        return false;
    }

    @Override
    public void exportClass(Integer idClass, String fileName) throws IOException {
        List<Student> lstStudent = new ArrayList<Student>();
        for (StudentClass stu_class:
                studentClassRepository.findStudentClassByIdClass(idClass)) {
            Student stu = studentRepositoty.findStudentByIdStudent(stu_class.getIdStudent());
            if(stu != null)
                lstStudent.add(stu);
        }
        ExportListClass.exportClass(lstStudent, fileName, clazzRepository.findClazzByIdClass(idClass).getClassName());
    }
}
