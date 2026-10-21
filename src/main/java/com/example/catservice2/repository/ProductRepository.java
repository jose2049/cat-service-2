package com.example.catservice2.repository;

import com.example.catservice2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.price >= :minPrice ORDER BY p.price ASC")
    List<Product> findByMinimumPrice(@Param("minPrice")BigDecimal minPrice);
}
