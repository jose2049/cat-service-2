package com.example.catservice2.repository;

import com.example.catservice2.model.Category;
import com.example.catservice2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(""" 
    SELECT p 
    FROM Product p 
    JOIN p.category c 
    WHERE LOWER(c.name) = LOWER(:categoryName) 
    ORDER BY p.price ASC 
    """)
    List <Product> findByCategoryName(
            @Param("categoryName") String categoryName);
}
