package com.longdk.productstudycasever2.service;

import com.longdk.productstudycasever2.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Long id);
}
