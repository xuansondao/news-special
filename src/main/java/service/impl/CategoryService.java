package service.impl;

import dao.ICategoryDAO;
import dao.impl.CategoryDaoImpl;
import model.Category;
import service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryDAO categoryDAO;

    public CategoryService(){
        this.categoryDAO = new CategoryDaoImpl();
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
}
