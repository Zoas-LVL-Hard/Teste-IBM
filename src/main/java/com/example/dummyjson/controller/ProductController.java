package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;

import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable @NotNull Long id) {
        return productService.getProductById(id);
    }
}
