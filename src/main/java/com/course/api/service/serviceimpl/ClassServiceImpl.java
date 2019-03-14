package com.course.api.service.serviceimpl;

import com.course.api.dto.ClassesDTO;
import com.course.api.entity.Clazz;
import com.course.api.repository.ClazzRepository;
import com.course.api.service.ClassService;
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
    public Clazz addClass(Clazz clazz){
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
