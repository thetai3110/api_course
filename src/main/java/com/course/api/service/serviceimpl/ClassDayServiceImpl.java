package com.course.api.service.serviceimpl;

import com.course.api.entity.Ca;
import com.course.api.entity.ClassDay;
import com.course.api.entity.SchoolDay;
import com.course.api.repository.ClassDayRepository;
import com.course.api.service.ClassDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("classDayService")
public class ClassDayServiceImpl implements ClassDayService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ClassDayRepository classDayRepository;

    @Override
    public List<ClassDay> getAll(){
        return classDayRepository.findAll();
    }

    @Override
    public ClassDay getClassDayById(Integer idClassDay) {
        return classDayRepository.findClassDayByIdClassDay(idClassDay);
    }

    @Override
    public List<ClassDay> getClassDayBySchoolDay(Integer idSd) {
        String query = "SELECT * FROM CLASS_DAY WHERE id_schoolday =:idSd";
        return entityManager.createNativeQuery(query,ClassDay.class).setParameter("idSd",idSd).getResultList();
    }

    @Override
    public List<ClassDay> getClassDayByCa(Integer idCa)  {
        String query = "SELECT * FROM CLASS_DAY WHERE id_ca =:idCa";
        return entityManager.createNativeQuery(query,ClassDay.class).setParameter("idCa",idCa).getResultList();
    }


    @Override
    public List<ClassDay> getClassDayByClass(Integer idClass) {
        return classDayRepository.findClassDayByIdClass(idClass);
    }

    @Override
    public ClassDay addClassDay(ClassDay classDay) {
        classDay.setCreatedDate(new Date());
        classDay.setModifyDate(new Date());
        classDayRepository.save(classDay);
        return classDay;
    }

    @Override
    public ClassDay updateClassDay(ClassDay classDay) {
        classDay.setModifyDate(new Date());
        classDayRepository.save(classDay);
        return classDay;
    }

    @Override
    public void removeClassDay(ClassDay classDay) {
        classDayRepository.delete(classDay);
    }
}
