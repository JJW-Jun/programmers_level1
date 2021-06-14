package com.example.simplesearch.controller;

import com.example.simplesearch.domain.Product;
import com.example.simplesearch.domain.ProductMyPriceRequestDto;
import com.example.simplesearch.domain.ProductRequestDto;
import com.example.simplesearch.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;


    @GetMapping("/products")
    public List<Product> readProducts() {
        System.out.println("================================");
        System.out.println("==============Read==============");
        System.out.println("================================");
        return productService.findAll();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto requestDto) {
        System.out.println("================================");
        System.out.println("==============A D D==============");
        System.out.println("================================");
        Product product = new Product(requestDto);
        return product;
    }

    @PutMapping("/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMyPriceRequestDto requestDto) {
        System.out.println("================================");
        System.out.println("=============UPDATE=============");
        System.out.println("================================");
        return productService.update(id, requestDto);
    }

    @DeleteMapping("/products/{id}")
    public Long deleteProduct(@PathVariable Long id, @RequestBody ProductRequestDto requestDto) {
        System.out.println("================================");
        System.out.println("==============Delete=============");
        System.out.println("================================");
        return productService.delete(id, requestDto);
    }
}