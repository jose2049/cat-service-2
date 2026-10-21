package com.example.catservice2.DTO;

import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        BigDecimal price,
        Long category_id
) { }
