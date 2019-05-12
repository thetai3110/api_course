package com.course.api.service;

import com.course.api.dto.NewsDTO;
import com.course.api.entity.News;

import java.util.List;

public interface NewsService {
    List<News> getAll() throws Exception;
    News getNewsById(Integer id) throws Exception;
    List<News> getNewsByCourse(Integer id) throws Exception;
    News addNews(NewsDTO newsDTO) throws Exception;
    News updateNews(NewsDTO newsDTO, Integer id) throws Exception;
    void removeNews(News news) throws Exception;
    List<News> paging(Integer page, Integer limit) throws Exception;
    Integer total() throws Exception;
    void updateView(News news) throws Exception;
}
