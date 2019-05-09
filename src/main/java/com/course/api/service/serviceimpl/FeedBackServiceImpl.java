package com.course.api.service.serviceimpl;

import com.course.api.entity.FeedBack;
import com.course.api.repository.FeedBackRepository;
import com.course.api.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service("feedBackService")
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FeedBack> getAll() {
        return feedBackRepository.findAll();
    }

    @Override
    public FeedBack getFeedBackById(Integer id) {
        return feedBackRepository.findFeedBackByIdFeedBack(id);
    }

    @Override
    public List<FeedBack> getFeedBackByCourse(Integer id) {
        return entityManager.createNativeQuery("Select * from FEEDBACK where id_course =:idCourse").setParameter("idCourse", id).getResultList();
    }

    @Override
    public FeedBack addFeedBack(FeedBack feedBack) {
        feedBack.setTime(new Date());
        feedBackRepository.save(feedBack);
        return feedBack;
    }

    @Override
    public void removeFeedBack(FeedBack sales){
        feedBackRepository.delete(sales);
    }
}
