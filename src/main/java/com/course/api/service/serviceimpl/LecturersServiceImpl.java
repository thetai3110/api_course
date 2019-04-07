package com.course.api.service.serviceimpl;

import com.course.api.dto.LecturersDTO;
import com.course.api.entity.Clazz;
import com.course.api.entity.Lecturers;
import com.course.api.entity.Majors;
import com.course.api.repository.AccountRepositoty;
import com.course.api.repository.LecturersRepository;
import com.course.api.repository.MajorsRepositoty;
import com.course.api.service.ClassService;
import com.course.api.service.LecturersService;
import com.course.api.service.MajorsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("lecturersService")
public class LecturersServiceImpl implements LecturersService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MajorsRepositoty majorsRepositoty;

    @Autowired
    private LecturersRepository lecturersRepository;

    @Autowired
    private AccountRepositoty accountRepositoty;

    @Autowired
    private ClassService classService;

    @Override
    public List<Lecturers> getAll() {
        return lecturersRepository.findAll();
    }

    @Override
    public Lecturers getLecturersById(Integer idLec) {
        return lecturersRepository.findLecturersByIdLecturers(idLec);
    }

    @Override
    public Lecturers getLecturersAccount(Integer idAccount) throws Exception {
        try {
            String query = "SELECT * FROM LECTURERS WHERE id_account =:idAccount";
            Lecturers lecturers = (Lecturers) entityManager.createNativeQuery(query, Lecturers.class).setParameter("idAccount", idAccount).getSingleResult();
            return lecturers;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<Lecturers> getByMajors(Integer idMajors) {
        return entityManager.createNativeQuery("select * from LECTURERS where id_majors =:idMajors",Lecturers.class).setParameter("idMajors",idMajors).getResultList();
    }

    @Override
    public Lecturers addLecturers(LecturersDTO lecturersDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<LecturersDTO, Lecturers>() {
            @Override
            protected void configure() {
                skip().setIdLecturers(null);
            }
        });
        Lecturers lecturers = modelMapper.map(lecturersDTO, Lecturers.class);
        lecturers.setMajors(majorsRepositoty.findMajorsByIdMajors(lecturersDTO.getIdMajors()));
        lecturers.setAccountLec(accountRepositoty.findAccountByIdAccount(lecturersDTO.getIdAccount()));
        lecturers.setCreatedDate(new Date());
        lecturers.setModifyDate(new Date());
        lecturersRepository.save(lecturers);
        return lecturers;
    }

    @Override
    public Lecturers updateLecturers(LecturersDTO lecturersDTO, Integer idLec)  {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<LecturersDTO, Lecturers>() {
            @Override
            protected void configure() {
                skip().setIdLecturers(null);
            }
        });
        Lecturers lecturers = modelMapper.map(lecturersDTO, Lecturers.class);
        lecturers.setIdLecturers(idLec);
        lecturers.setMajors(majorsRepositoty.findMajorsByIdMajors(lecturersDTO.getIdMajors()));
        lecturers.setAccountLec(accountRepositoty.findAccountByIdAccount(lecturersDTO.getIdAccount()));
        lecturers.setModifyDate(new Date());
        lecturersRepository.save(lecturers);
        return lecturers;
    }

    @Override
    public Lecturers updateLecturers(Lecturers lecturers) throws Exception {
        lecturers.setModifyDate(new Date());
        lecturersRepository.save(lecturers);
        return lecturers;
    }

    @Override
    public void removeLecturers(Lecturers lecturers) throws Exception {
        if(lecturers.getAccountLec() != null)
            accountRepositoty.delete(lecturers.getAccountLec());
        if(!classService.getClassByLecturers(lecturers.getIdLecturers()).isEmpty()){
            for (Clazz cl:
                    classService.getClassByLecturers(lecturers.getIdLecturers())) {
                cl.setLecturers(null);
                classService.updateClass(cl);
            }
        }
        lecturersRepository.delete(lecturers);
    }
}
