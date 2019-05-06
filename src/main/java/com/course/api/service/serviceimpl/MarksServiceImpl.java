package com.course.api.service.serviceimpl;

import com.course.api.entity.Marks;
import com.course.api.repository.MarksRepository;
import com.course.api.service.CertificateService;
import com.course.api.service.ExamService;
import com.course.api.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("marksService")
public class MarksServiceImpl implements MarksService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private CertificateService certificateService;

    @Autowired
    private ExamService examService;

    @Override
    public List<Marks> getAll() {
        return marksRepository.findAll();
    }

    @Override
    public Marks getMarksById(Integer idMarks) {
        return marksRepository.findMarksByIdMarks(idMarks);
    }

    @Override
    public List<Marks> getMarksByClass(Integer idClass) {
        return entityManager.createNativeQuery("select * from MARKS where id_class =:idClass",Marks.class).setParameter("idClass", idClass).getResultList();
    }

    @Override
    public List<Marks> getMarksByClassAndMark(Integer idClass) {
        return entityManager.createNativeQuery("select * from MARKS where id_class =:idClass and marks >=5",Marks.class).setParameter("idClass", idClass).getResultList();
    }

    @Override
    public List<Marks> getMarksByStudent(Integer idStudent) {
        return entityManager.createNativeQuery("select * from MARKS where id_student =:idStudent",Marks.class).setParameter("idStudent", idStudent).getResultList();
    }

    @Override
    public List<Marks> getMarksByNameAndCMND(String name, String cmnd) {
        return entityManager.createNativeQuery("select * from MARKS m join STUDENT s on m.id_student = s.id_student where s.student_name =:studentName and s.cmnd =:cmnd  ",Marks.class).setParameter("studentName", name).setParameter("cmnd", cmnd).getResultList();
    }

    @Override
    public Marks getMarksByClassAndStudent(Integer idClass, Integer idStudent) {
        Marks marks = (Marks) entityManager.createNativeQuery("select * from MARKS where id_class =:idClass AND id_student =:idStudent",Marks.class).setParameter("idClass", idClass).setParameter("idStudent", idStudent).getSingleResult();
        if(marks != null){
            return marks;
        }else return null;
    }

    @Override
    public Marks addMarks(Marks marks) {
        marks.setCreatedDate(new Date());
        marks.setModifyDate(new Date());
        marksRepository.save(marks);
        return marks;
    }

    @Override
    public Marks updateMarks(Marks marks) {
        marks.setModifyDate(new Date());
        marksRepository.save(marks);
        return marks;
    }

    @Override
    public void removeMarks(Marks marks) {
        marksRepository.delete(marks);
    }

    @Override
    public Marks save(Float marks, Integer id) {
        Marks marks1 = marksRepository.findMarksByIdMarks(id);
        marks1.setMarks(marks);
        marks1.setModifyDate(new Date());
        marksRepository.save(marks1);
        return marks1;
    }

    @Override
    public List<Marks> saveALl(List<String> data) {
        List<Marks> lstmarks = new ArrayList<>();
        for (String d:
             data) {
            String[] str = d.split("-");
            Marks marks = marksRepository.findMarksByIdMarks(Integer.parseInt(str[1]));
            marks.setMarks(Float.parseFloat(str[0]));
            marks.setModifyDate(new Date());
            lstmarks.add(marks);
            marksRepository.save(marks);
        }
        return lstmarks;
    }
}
