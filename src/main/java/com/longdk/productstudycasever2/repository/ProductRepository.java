package com.longdk.productstudycasever2.repository;

import com.longdk.productstudycasever2.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Page<Product> findAllByNameContaining(Pageable pageable,String name);
}
