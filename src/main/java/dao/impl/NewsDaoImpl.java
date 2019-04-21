package dao.impl;

import dao.INewsDAO;
import mapper.NewsMapper;
import model.News;

import java.util.List;

public class NewsDaoImpl extends AbtractDAO<News> implements INewsDAO {

    @Override
    public void insertNews(News news) {
        String sql = "INSERT INTO news(title, shortDescription, content, createdBy, createdDate, thumbnail, status, categoryID) VALUES (?,?,?,?,?,?,?,?)";
        insertOrUpdate(sql, news.getTitle(), news.getShortDescription(), news.getContent(),
                news.getCreatedBy(), news.getCreatedDate(),
                news.getThumbnail(),news.getStatus() ,news.getCategoryID());
    }

    @Override
    public List<News> findAll() {
        String sql = "SELECT * FROM news";
        return query(sql, new NewsMapper());
    }

    @Override
    public News findNewsById(long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<News> list = query(sql, new NewsMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<News> findNewsByContent(String content) {
        String sql = "SELECT * FROM news WHERE content LIKE  ?";
        List<News> list = query(sql, new NewsMapper(), "%" + content + "%");
        return list;
    }

    @Override
    public void update(Long id, News news) {
        String sql = "UPDATE news SET title = ?, shortDescription = ?, content = ?, createdBy = ?, createdDate = ?, modifiedBy = ?, modifiedDate = ?, thumbnail = ?, categoryID = ? WHERE id = ?";
        insertOrUpdate(sql, news.getTitle(), news.getShortDescription(), news.getContent(), news.getCreatedBy(), news.getCreatedDate(), news.getModifiedBy(), news.getModifiedDate(), news.getThumbnail(), news.getCategoryID(), id);
    }

}
