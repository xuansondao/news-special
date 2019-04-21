package dao;

import model.Category;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<Category>{
    List<Category> findAll();
}
