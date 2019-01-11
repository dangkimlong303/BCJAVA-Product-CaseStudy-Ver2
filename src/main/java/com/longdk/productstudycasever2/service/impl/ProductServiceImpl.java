package com.longdk.productstudycasever2.service.impl;

import com.longdk.productstudycasever2.models.Product;
import com.longdk.productstudycasever2.repository.ProductRepository;
import com.longdk.productstudycasever2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByNameContaining(Pageable pageable, String name) {
        return productRepository.findAllByNameContaining(pageable,name);

    }

}
