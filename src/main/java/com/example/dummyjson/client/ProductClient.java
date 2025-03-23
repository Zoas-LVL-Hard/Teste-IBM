package com.example.dummyjson.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;

import jakarta.validation.Valid;

@FeignClient(name = "dummyjson", url = "${api.dummyjson.url}")
public interface ProductClient {

    @GetMapping()
    ProductResponse getAllProducts();

    @GetMapping("/{id}")
    Product getProductById(@PathVariable("id") @Valid Long id);
}
