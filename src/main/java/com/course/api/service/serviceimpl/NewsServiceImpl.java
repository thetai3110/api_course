package com.course.api.service.serviceimpl;

import com.course.api.dto.NewsDTO;
import com.course.api.entity.News;
import com.course.api.repository.CourseRepository;
import com.course.api.repository.NewsRepository;
import com.course.api.service.NewsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<News> getAll() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(Integer id) {
        return newsRepository.findNewsByIdNews(id);
    }

    @Override
    public List<News> getNewsByCourse(Integer id) {
        return entityManager.createNativeQuery("select * from NEWS where id_course= :idCourse", News.class).setParameter("idCourse", id).getResultList();
    }

    @Override
    public News addNews(NewsDTO newsDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<NewsDTO, News>() {
            @Override
            protected void configure() {
                skip().setIdNews(null);
            }
        });
        News news = modelMapper.map(newsDTO, News.class);
        news.setCourse(courseRepository.findCourseByIdCourse(newsDTO.getIdCourse()));
        news.setViews(0);
        news.setCreatedBy(newsDTO.getIdEmp());
        news.setModifyBy(newsDTO.getIdEmp());
        news.setCreatedDate(new Date());
        news.setModifyDate(new Date());
        newsRepository.save(news);
        return news;
    }

    @Override
    public News updateNews(NewsDTO newsDTO, Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<NewsDTO, News>() {
            @Override
            protected void configure() {
                skip().setIdNews(null);
            }
        });
        News news = modelMapper.map(newsDTO, News.class);
        news.setIdNews(id);
        news.setCourse(courseRepository.findCourseByIdCourse(newsDTO.getIdCourse()));
        news.setModifyBy(newsDTO.getIdEmp());
        news.setModifyDate(new Date());
        newsRepository.save(news);
        return news;
    }

    @Override
    public void removeNews(News news) {
        newsRepository.delete(news);
    }

    @Override
    public List<News> paging(Integer page, Integer limit) {
        Integer cur = (page - 1) * limit;
        return entityManager.createNativeQuery("select * from NEWS", News.class).setFirstResult(cur).setMaxResults(limit).getResultList();
    }

    @Override
    public Integer total() {
        List<News> feedBacks = newsRepository.findAll();
        return feedBacks.size()/6+1;
    }

    @Override
    public void updateView(News news) {
        news.setViews(news.getViews() + 1);
        newsRepository.save(news);
    }
}
