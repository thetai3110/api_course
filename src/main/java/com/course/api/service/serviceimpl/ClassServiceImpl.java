package com.course.api.service.serviceimpl;

import com.course.api.dto.ClassesDTO;
import com.course.api.entity.Clazz;
import com.course.api.repository.ClazzRepository;
import com.course.api.repository.CourseRepository;
import com.course.api.repository.LecturersRepository;
import com.course.api.repository.RoomRepository;
import com.course.api.service.ClassService;
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
    public Clazz updateClass(Clazz clazz) {
        clazz.setModifyDate(new Date());
        clazzRepository.save(clazz);
        return clazz;
    }

    @Override
    public void removeClass(Clazz clazz) {
        clazzRepository.delete(clazz);
    }
}
