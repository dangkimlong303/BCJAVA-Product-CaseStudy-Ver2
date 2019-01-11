package com.longdk.productstudycasever2.formatter;

import com.longdk.productstudycasever2.models.Category;
import com.longdk.productstudycasever2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {
    private CategoryService categoryService;

    @Autowired
    private CategoryFormatter(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return categoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return null;
    }
}
