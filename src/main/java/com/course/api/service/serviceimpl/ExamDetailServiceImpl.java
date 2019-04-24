package com.course.api.service.serviceimpl;

import com.course.api.entity.ExamDetail;
import com.course.api.repository.ExamDetailRepository;
import com.course.api.service.ExamDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("examDetailSerivce")
public class ExamDetailServiceImpl implements ExamDetailService {

    @Autowired
    private ExamDetailRepository examDetailRepository;

    @Override
    public List<ExamDetail> getAll() {
        return examDetailRepository.findAll();
    }

    @Override
    public ExamDetail getExamDetailById(Integer idExamDetail) {
        return examDetailRepository.findExamDetailByIdExamDetail(idExamDetail);
    }

    @Override
    public List<ExamDetail> getExamDetailByExam(Integer id) {
        return examDetailRepository.findExamDetailsByIdExam(id);
    }

    @Override
    public ExamDetail addExamDetail(ExamDetail examDetail) {
        examDetail.setCreatedDate(new Date());
        examDetail.setModifyDate(new Date());
        examDetailRepository.save(examDetail);
        return examDetail;
    }

    @Override
    public List<ExamDetail> addMultiExamDetail(List<ExamDetail> examDetails) {
        for (ExamDetail ex:
             examDetails) {
            ex.setCreatedDate(new Date());
            ex.setModifyDate(new Date());
            examDetailRepository.save(ex);
        }
        return examDetails;
    }

    @Override
    public ExamDetail updateIExamDetail(ExamDetail examDetail) {
        examDetail.setModifyDate(new Date());
        examDetailRepository.save(examDetail);
        return examDetail;
    }

    @Override
    public void removeExamDetail(ExamDetail examDetail) {
        examDetailRepository.delete(examDetail);
    }
}
