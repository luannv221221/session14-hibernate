package com.ra.model.dao.product;

import com.ra.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductDAOImpl implements ProductDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            products = session.createQuery("from Product ",Product.class).list();
        } catch (Exception exception){
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public boolean create(Product product) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
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
