package com.course.api.repository;

import com.course.api.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {
    FeedBack findFeedBackByIdFeedBack(Integer id);

}
