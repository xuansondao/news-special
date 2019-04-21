package service.impl;

import dao.INewsDAO;
import dao.impl.NewsDaoImpl;
import model.News;
import service.INewsService;

import java.sql.Timestamp;
import java.util.List;

public class NewService implements INewsService {
    private INewsDAO newsDAO;

    public NewService(){
        this.newsDAO = new NewsDaoImpl();
    }

    @Override
    public void createdNews(News news) {
        news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        news.setCreatedBy("");
        newsDAO.insertNews(news);
    }

    @Override
    public void updateNews(Long id, News updateNews) {
        News oldNews = newsDAO.findNewsById(id);
        updateNews.setCreatedDate(oldNews.getCreatedDate());
        updateNews.setCreatedBy(oldNews.getCreatedBy());
        updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateNews.setModifiedBy("");

        newsDAO.update(id, updateNews);
    }

    @Override
    public News findOneById(long id) {
        return newsDAO.findNewsById(id);
    }

    @Override
    public List<News> findAll() {
        return newsDAO.findAll();
    }
}
