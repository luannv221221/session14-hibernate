package com.ra.model.service.category;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Boolean create(Category category) {
        return null;
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public Boolean update(Category category) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
