package com.course.api.service;

import com.course.api.entity.FeedBack;

import java.util.List;

public interface FeedBackService {
    List<FeedBack> getAll() throws Exception;
    FeedBack getFeedBackById(Integer id) throws Exception;
    List<FeedBack> getFeedBackByCourse(Integer id) throws Exception;
    FeedBack addFeedBack(FeedBack feedBack) throws Exception;
    void removeFeedBack(FeedBack sales) throws Exception;
}
