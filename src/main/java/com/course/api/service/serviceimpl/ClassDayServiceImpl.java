package com.course.api.service.serviceimpl;

import com.course.api.dto.ClassDayDTO;
import com.course.api.dto.ClassesDTO;
import com.course.api.entity.Ca;
import com.course.api.entity.ClassDay;
import com.course.api.entity.SchoolDay;
import com.course.api.repository.CaRepositoty;
import com.course.api.repository.ClassDayRepository;
import com.course.api.repository.SchoolDayRepository;
import com.course.api.service.ClassDayService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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

    @Autowired
    private SchoolDayRepository schoolDayRepository;

    @Autowired
    private CaRepositoty caRepositoty;

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
    public List<ClassDayDTO> getClassDayByClass(Integer idClass) {
        String query = "SELECT * FROM CLASS_DAY cd join CLASS cl on cd.id_class = cl.id_class WHERE cd.id_class =:idClass";
        return entityManager.createNativeQuery(query, ClassDayDTO.class).setParameter("idClass",idClass).getResultList();
    }

    @Override
    public ClassDay addClassDay(ClassDayDTO classDayDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<ClassDayDTO, ClassDay>() {
            @Override
            protected void configure() {
                skip().setIdClassDay(null);
            }
        });
        ClassDay classDay = modelMapper.map(classDayDTO, ClassDay.class);
        classDay.setSchoolDay(schoolDayRepository.findSchoolDayByIdSchoolDay(classDayDTO.getIdSchoolday()));
        classDay.setCa(caRepositoty.findCaByIdCa(classDayDTO.getIdCa()));
        classDay.setCreatedDate(new Date());
        classDay.setModifyDate(new Date());
        classDayRepository.save(classDay);
        return classDay;
    }

    @Override
    public ClassDay updateClassDay(ClassDayDTO classDayDTO, Integer idClassDay) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<ClassDayDTO, ClassDay>() {
            @Override
            protected void configure() {
                skip().setIdClassDay(null);
            }
        });
        ClassDay classDay = modelMapper.map(classDayDTO, ClassDay.class);
        classDay.setIdClassDay(idClassDay);
        classDay.setSchoolDay(schoolDayRepository.findSchoolDayByIdSchoolDay(classDayDTO.getIdSchoolday()));
        classDay.setCa(caRepositoty.findCaByIdCa(classDayDTO.getIdCa()));
        classDay.setModifyDate(new Date());
        classDayRepository.save(classDay);
        return classDay;
    }

    @Override
    public void removeClassDay(ClassDay classDay) {
        classDayRepository.delete(classDay);
    }
}
