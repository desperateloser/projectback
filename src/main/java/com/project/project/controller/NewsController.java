package com.project.project.controller;
import com.project.project.model.News;
import com.project.project.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;


@RestController
public class NewsController {
    @Autowired
    NewsRepository newsRepository;

    @CrossOrigin()
    @GetMapping("/news")
    public List<News> retrieveAllNews() {
        return (List<News>) newsRepository.findAll();
    }


    @CrossOrigin()
    @DeleteMapping("/news/{id_news}")
    public void deleteNews(@PathVariable int id_news) {
        newsRepository.deleteById(id_news);
    }


    @CrossOrigin()
    @PostMapping(value = "/news", consumes =  "application/json", produces = "application/json")
    public News createnews(@RequestBody News news) {
        return newsRepository.save(news);
    }


    @CrossOrigin()
    @PutMapping("/news/{id_news}")
    public News updateNews (@PathVariable int id_news, @RequestBody News putRequest) {

        return newsRepository.findById(id_news).map(news -> {
            news.setNews_title(putRequest.getNews_title());
            news.setNews_description(putRequest.getNews_description());
            news.setPublishing_date(putRequest.getPublishing_date());
            return newsRepository.save(news);
        }).orElseThrow(() -> new ResourceAccessException("id_news " + id_news + " not found"));
    }
    }
