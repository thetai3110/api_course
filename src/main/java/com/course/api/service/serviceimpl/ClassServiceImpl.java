package com.course.api.service.serviceimpl;

import com.course.api.dto.ClassesDTO;
import com.course.api.entity.ClassDay;
import com.course.api.entity.Clazz;
import com.course.api.entity.StudentClass;
import com.course.api.repository.*;
import com.course.api.service.ClassDayService;
import com.course.api.service.ClassService;
import com.course.api.service.StudentClassService;
import com.course.api.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public List<Clazz> getClassByLecturers(Integer idLec) {
        return entityManager.createNativeQuery("select * from CLASS where id_lecturers =:idLec",Clazz.class).setParameter("idLec",idLec).getResultList();
    }

    @Override
    public List<Clazz> getClassByRoom(Integer idRoom) {
        return entityManager.createNativeQuery("select * from CLASS where id_room =:idRoom",Clazz.class).setParameter("idRoom",idRoom).getResultList();
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
    public Clazz updateClass(Clazz clazz) throws Exception {
        clazz.setModifyDate(new Date());
        clazzRepository.save(clazz);
        return clazz;
    }

    @Override
    public void removeClass(Clazz clazz) throws Exception {
        if(!studentClassRepository.findStudentClassByIdClass(clazz.getIdClass()).isEmpty()){
            for (StudentClass student:
                    studentClassRepository.findStudentClassByIdClass(clazz.getIdClass())) {
                studentClassService.removeStudentClass(student);
            }
        }
        if(!classDayRepository.findClassDayByIdClass(clazz.getIdClass()).isEmpty()){
            for (ClassDay classDay:
                    classDayRepository.findClassDayByIdClass(clazz.getIdClass())) {
                classDayService.removeClassDay(classDay);
            }
        }
        clazzRepository.delete(clazz);
    }
}
