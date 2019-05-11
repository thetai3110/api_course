package com.course.api.service;

import com.course.api.dto.FeedBackDTO;
import com.course.api.entity.FeedBack;

import java.util.List;

public interface FeedBackService {
    List<FeedBack> getAll() throws Exception;
    FeedBack getFeedBackById(Integer id) throws Exception;
    List<FeedBack> getFeedBackByCourse(Integer id) throws Exception;
    FeedBack addFeedBack(FeedBackDTO feedBackDTO) throws Exception;
    void removeFeedBack(FeedBack sales) throws Exception;
    List<FeedBack> paging(Integer page, Integer limit) throws Exception;
    Integer total() throws Exception;

}
