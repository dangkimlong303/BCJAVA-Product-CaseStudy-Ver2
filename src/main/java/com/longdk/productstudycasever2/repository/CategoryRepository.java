package com.longdk.productstudycasever2.repository;

import com.longdk.productstudycasever2.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
