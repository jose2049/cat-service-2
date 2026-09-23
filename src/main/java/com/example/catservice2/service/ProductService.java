package com.example.catservice2.service;

import com.example.catservice2.model.Product;
import org.springframework.stereotype.Service;
import com.example.catservice2.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }
}
