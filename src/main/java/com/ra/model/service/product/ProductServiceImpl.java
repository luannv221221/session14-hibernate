package com.ra.model.service.product;

import com.ra.model.dao.product.ProductDAO;
import com.ra.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDAO productDAO;
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean create(Product product) {
        return productDAO.create(product);
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
