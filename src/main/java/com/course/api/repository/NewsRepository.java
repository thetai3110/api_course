package com.course.api.repository;

import com.course.api.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {
    News findNewsByIdNews(Integer id);
}
