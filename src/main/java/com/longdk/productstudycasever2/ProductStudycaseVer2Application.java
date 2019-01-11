package com.longdk.productstudycasever2;

import com.longdk.productstudycasever2.service.CategoryService;
import com.longdk.productstudycasever2.service.ProductService;
import com.longdk.productstudycasever2.service.impl.CategoryServiceImpl;
import com.longdk.productstudycasever2.service.impl.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductStudycaseVer2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductStudycaseVer2Application.class, args);
	}

	@Bean
	public ProductService productService(){
		return new ProductServiceImpl();
	}

	@Bean
	public CategoryService categoryService(){
		return new CategoryServiceImpl();
	}
}

