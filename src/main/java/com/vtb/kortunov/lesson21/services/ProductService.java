package com.vtb.kortunov.lesson21.services;

import com.vtb.kortunov.lesson21.entities.Product;
import com.vtb.kortunov.lesson21.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProduct(Long id) {
        return productRepository.get(id);
    }

    public List<Product> getProducts() {
        return productRepository.getAll();
    }
}
