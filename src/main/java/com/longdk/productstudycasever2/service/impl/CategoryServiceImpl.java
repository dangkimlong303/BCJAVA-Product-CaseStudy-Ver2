package com.longdk.productstudycasever2.service.impl;

import com.longdk.productstudycasever2.models.Category;
import com.longdk.productstudycasever2.repository.CategoryRepository;
import com.longdk.productstudycasever2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
