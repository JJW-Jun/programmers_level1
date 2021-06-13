package com.example.simplesearch.service;

import com.example.simplesearch.domain.Product;
import com.example.simplesearch.domain.ProductMyPriceRequestDto;
import com.example.simplesearch.domain.ProductRequestDto;
import com.example.simplesearch.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, @RequestBody ProductMyPriceRequestDto requestDto) {
        Product findProduct = productRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 상품이 존재하지 않습니다."));
        findProduct.update(requestDto);
        return id;
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Long delete(Long id, ProductRequestDto requestDto) {
        Product deleteProduct = productRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 상품입니다."));
        return 1L;
//        return productRepository.delete;
    }
}
