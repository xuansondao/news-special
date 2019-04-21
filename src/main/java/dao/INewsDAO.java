package dao;

import model.News;

import java.util.List;

public interface INewsDAO extends GenericDAO<News> {
    void insertNews(News news);

    List<News> findAll();

    News findNewsById(long id);

    List<News> findNewsByContent(String content);

    void update(Long id, News news);
}
