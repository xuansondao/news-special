package service;

import model.News;

import java.util.List;

public interface INewsService {
    void createdNews(News news);

    void updateNews(Long id, News updateNews);

    News findOneById(long id);

    List<News> findAll();
}
