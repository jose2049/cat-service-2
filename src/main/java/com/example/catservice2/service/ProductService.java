package com.example.catservice2.service;

import com.example.catservice2.DTO.CreateProductRequest;
import com.example.catservice2.model.Category;
import com.example.catservice2.model.Product;
import com.example.catservice2.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.catservice2.repository.ProductRepository;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(CreateProductRequest request) {
        if (request.category_id() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "categoryId is required");
        }

        Category category = categoryRepository
                .findById(request.category_id())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Category does not exist"));

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);

        return productRepository.save(product);
    }
    public Product getById(Long id) {
        return productRepository.findById(id).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }
    public List<Product> getByMinimumPrice(BigDecimal minPrice) {
        return productRepository.findByMinimumPrice(minPrice);
    }

    public List<Product> getByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
