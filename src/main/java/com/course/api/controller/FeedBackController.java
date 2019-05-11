package com.course.api.controller;

import com.course.api.dto.FeedBackDTO;
import com.course.api.entity.FeedBack;
import com.course.api.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<FeedBack>> getAllFeedBack() {
        try {
            List<FeedBack> feedBacks = feedBackService.getAll();
            if (feedBacks.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<FeedBack>>(feedBacks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/paging/{page}", method = RequestMethod.GET)
    public ResponseEntity<List<FeedBack>> paging(@PathVariable(name = "page") Integer page) {
        try {
            List<FeedBack> feedBacks = feedBackService.paging(page, 6);
            if (feedBacks.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<FeedBack>>(feedBacks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FeedBack> getFeedBackById(@PathVariable(name = "id") Integer id) {
        try {
            FeedBack feedBack = feedBackService.getFeedBackById(id);
            if (feedBack == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<FeedBack>(feedBack, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<FeedBack>> getFeedBackByCourse(@PathVariable(name = "id") Integer id) {
        try {
            List<FeedBack> feedBacks = feedBackService.getFeedBackByCourse(id);
            if (feedBacks.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<FeedBack>>(feedBacks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<FeedBack> addFeedBack(@RequestBody FeedBackDTO feedBackDTO) {
        try {
            if (feedBackDTO == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<FeedBack>(feedBackService.addFeedBack(feedBackDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteFeedBack(@PathVariable(name = "id") Integer id) {
        try {
            FeedBack feedBack = feedBackService.getFeedBackById(id);
            if (feedBack == null) return false;
            feedBackService.removeFeedBack(feedBack);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public Integer total() {
        try {
            Integer total = feedBackService.total();
            return total;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
