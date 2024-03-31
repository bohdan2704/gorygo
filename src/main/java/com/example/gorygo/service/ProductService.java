package com.example.gorygo.service;

import com.example.gorygo.dto.get.ProductDto;
import com.example.gorygo.dto.post.CreateProductDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductDto save(CreateProductDto createProductDto);

    ProductDto findById(Long id);

    List<ProductDto> findAll(Pageable pageable);

    ProductDto updateById(Long id, CreateProductDto productDto);

    ProductDto addReviewToProduct(Long productId, Long reviewId);

    ProductDto addQuestionToProduct(Long productId, Long questionId);

    void deleteById(Long id);
}
