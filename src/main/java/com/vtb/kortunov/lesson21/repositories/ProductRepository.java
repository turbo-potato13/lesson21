package com.vtb.kortunov.lesson21.repositories;

import com.vtb.kortunov.lesson21.PrepareFactory;
import com.vtb.kortunov.lesson21.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class ProductRepository {

    private final PrepareFactory factory;

    @Autowired
    public ProductRepository(PrepareFactory factory) {
        this.factory = factory;
    }

    public void save(Product product) {
        factory.getSession().beginTransaction();
        factory.getSession().save(product);
        factory.getSession().getTransaction().commit();
        factory.getSession().close();
    }

    public Product get(Long id) {
        factory.getSession().beginTransaction();
        Product product = factory.getSession().get(Product.class, id);
        factory.getSession().getTransaction().commit();
        factory.getSession().close();
        return product;
    }

    public List<Product> getAll() {
        factory.getSession().beginTransaction();
        List<Product> products = factory.getSession().createQuery("SELECT p FROM Product p", Product.class).getResultList();
        factory.getSession().getTransaction().commit();
        factory.getSession().close();
        return products;
    }

}
