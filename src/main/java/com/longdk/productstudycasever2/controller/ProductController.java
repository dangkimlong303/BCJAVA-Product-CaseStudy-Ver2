package com.longdk.productstudycasever2.controller;

import com.longdk.productstudycasever2.models.Category;
import com.longdk.productstudycasever2.models.Product;
import com.longdk.productstudycasever2.service.CategoryService;
import com.longdk.productstudycasever2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categories(Pageable pageable){
        return categoryService.findAll(pageable);
    }

    @GetMapping("product-create")
    public ModelAndView showCreateProductForm(){
        return new ModelAndView("product/create","product",new Product());
    }

    @PostMapping("product-create")
    public ModelAndView createProduct(@Validated @ModelAttribute("product")Product product, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("product/create");
        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject(bindingResult.getModel());
            return modelAndView;
        }else {
            productService.save(product);
            modelAndView.addObject("mess","Product create success!!");
            return modelAndView;
        }
    }

    @GetMapping("product-list")
    public ModelAndView showListProductForm(@PageableDefault(size = 3)Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        return new ModelAndView("product/list","products",products);
    }
    @GetMapping("product-edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable Long id){
        Product product = productService.findById(id);
        return new ModelAndView("product/edit","product",product);
    }
    @PostMapping("product-edit")
    public ModelAndView EditProduct(@Validated @ModelAttribute("product")Product product,BindingResult result){
        ModelAndView modelAndView = new ModelAndView("product/edit");
        if (result.hasFieldErrors()){
            modelAndView.addObject(result.getModel());
            return modelAndView;
        }else {
            productService.save(product);
            modelAndView.addObject("message","Edit Product Success!!");
            return modelAndView;
        }
    }
    @GetMapping("product-delete/{id}")
    public ModelAndView showDeleteProductForm(@PathVariable Long id){
        Product product = productService.findById(id);
        return new ModelAndView("product/delete","product",product);
    }

    @PostMapping("product-delete")
    public String  deleteForm(@ModelAttribute("product") Product product){
        productService.delete(product.getId());
        return "redirect:product-list";
    }
    @GetMapping("product-search")
    public ModelAndView showSearchProductForm(@PageableDefault(size = 2)Pageable pageable, @RequestParam("name") String name){
        Page<Product> products = productService.findAllByNameContaining(pageable,name);
        ModelAndView modelAndView = new ModelAndView("product/list-search");
        modelAndView.addObject("products",products);
        modelAndView.addObject("name",name);
        return modelAndView;
    }
}
