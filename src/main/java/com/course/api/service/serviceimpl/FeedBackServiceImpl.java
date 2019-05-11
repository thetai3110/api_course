package com.course.api.service.serviceimpl;

import com.course.api.dto.FeedBackDTO;
import com.course.api.entity.FeedBack;
import com.course.api.repository.CourseRepository;
import com.course.api.repository.FeedBackRepository;
import com.course.api.service.FeedBackService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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

    @Autowired
    private CourseRepository courseRepository;

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
    public FeedBack addFeedBack(FeedBackDTO feedBackDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<FeedBackDTO, FeedBack>() {
            @Override
            protected void configure() {
                skip().setIdFeedBack(null);
            }
        });
        FeedBack feedBack = modelMapper.map(feedBackDTO, FeedBack.class);
        feedBack.setCourse(courseRepository.findCourseByIdCourse(feedBackDTO.getIdCourse()));
        feedBack.setTime(new Date());
        feedBackRepository.save(feedBack);
        return feedBack;
    }

    @Override
    public void removeFeedBack(FeedBack sales){
        feedBackRepository.delete(sales);
    }

    @Override
    public List<FeedBack> paging(Integer page, Integer limit) {
        Integer cur = (page - 1) * limit;
        return entityManager.createNativeQuery("select * from FEEDBACK", FeedBack.class).setFirstResult(cur).setMaxResults(limit).getResultList();
    }

    @Override
    public Integer total() {
        List<FeedBack> feedBacks = feedBackRepository.findAll();
        return feedBacks.size()/6+1;
    }
}
