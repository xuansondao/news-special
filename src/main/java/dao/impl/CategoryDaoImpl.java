package dao.impl;

import dao.ICategoryDAO;
import mapper.CategoryMapper;
import model.Category;

import java.util.List;

public class CategoryDaoImpl extends AbtractDAO<Category> implements ICategoryDAO {
    @Override
    public List<Category> findAll() {
        String sql = "SELECT * FROM category";
        return query(sql, new CategoryMapper());
    }
}
