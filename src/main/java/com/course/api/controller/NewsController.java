package com.course.api.controller;

import com.course.api.dto.NewsDTO;
import com.course.api.entity.News;
import com.course.api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<News>> getAllNews() {
        try {
            List<News> news = newsService.getAll();
            if (news.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<News>>(news, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/paging/{page}", method = RequestMethod.GET)
    public ResponseEntity<List<News>> paging(@PathVariable(name = "page") Integer page) {
        try {
            List<News> news = newsService.paging(page, 6);
            if (news.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<News>>(news, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<News> getNewsById(@PathVariable(name = "id") Integer id) {
        try {
            News news = newsService.getNewsById(id);
            if (news == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<News>(news, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<News>> getNewsByCourse(@PathVariable(name = "id") Integer id) {
        try {
            List<News> news = newsService.getNewsByCourse(id);
            if (news.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<News>>(news, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<News> addNews(@RequestBody NewsDTO newsDTO) {
        try {
            if (newsDTO == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
            if(!newsDTO.getImage().equals("")){
                String[] img = newsDTO.getImage().split("fakepath");
                newsDTO.setImage(img[1]);
            }else{
                newsDTO.setImage("");
            }
            //
            if(!newsDTO.getAvatar().equals("")){
                String[] img = newsDTO.getAvatar().split("fakepath");
                newsDTO.setAvatar(img[1]);
            }else{
                newsDTO.setAvatar("");
            }
            return new ResponseEntity<News>(newsService.addNews(newsDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<News> updateNews(@PathVariable(name = "id") Integer id, @RequestBody NewsDTO newsDTO) {
        try {
            News curNews = newsService.getNewsById(id);
            if (curNews == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
            if(!newsDTO.getImage().equals("")){
                String[] img = newsDTO.getImage().split("fakepath");
                newsDTO.setImage(img[1]);
            }else{
                String img = curNews.getImage() == null || curNews.getImage().equals("") ? "" : curNews.getImage();
                newsDTO.setImage(img);
            }
            if(!newsDTO.getAvatar().equals("")){
                String[] img = newsDTO.getAvatar().split("fakepath");
                newsDTO.setAvatar(img[1]);
            }else{
                String img = curNews.getAvatar() == null || curNews.getAvatar().equals("") ? "" : curNews.getAvatar();
                newsDTO.setAvatar(img);
            }
            return new ResponseEntity<News>(newsService.updateNews(newsDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteNews(@PathVariable(name = "id") Integer id) {
        try {
            News news = newsService.getNewsById(id);
            if (news == null) return false;
            newsService.removeNews(news);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public Integer total() {
        try {
            Integer total = newsService.total();
            return total;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping(value = "/views/{id}", method = RequestMethod.POST)
    public Integer updateView(@PathVariable(name = "id") Integer id, @RequestBody News news) {
        try {
            if(news == null) return 0;
            news.setIdNews(id);
            newsService.updateView(news);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
