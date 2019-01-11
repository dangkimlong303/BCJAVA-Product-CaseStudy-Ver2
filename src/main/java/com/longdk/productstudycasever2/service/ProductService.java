package com.longdk.productstudycasever2.service;

import com.longdk.productstudycasever2.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);

    void save(Product product);

    void delete(Long id);

    Page<Product> findAllByNameContaining(Pageable pageable,String name);
}
