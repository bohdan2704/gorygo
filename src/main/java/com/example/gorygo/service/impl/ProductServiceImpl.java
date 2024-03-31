package com.example.gorygo.service.impl;

import com.example.gorygo.dto.get.ProductDto;
import com.example.gorygo.dto.post.CreateProductDto;
import com.example.gorygo.mapper.ProductMapper;
import com.example.gorygo.model.Product;
import com.example.gorygo.model.Question;
import com.example.gorygo.repository.ProductRepository;
import com.example.gorygo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto save(CreateProductDto createProductDto) {
        Product model = productMapper.toModel(createProductDto);
//        model.setCreatedAt(LocalDateTime.now());
        Product saved = productRepository.save(model);
        return productMapper.toDto(saved);
    }

    @Override
    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(productMapper::toDto).orElseThrow();
    }

    @Override
    public List<ProductDto> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).stream().map(productMapper::toDto).toList();
    }

    @Override
    public ProductDto updateById(Long id, CreateProductDto productDto) {
        Product model = productMapper.toModel(productDto);
        model.setId(id);
//        ProductDto toBeUpdated = findById(id);
//        model.setCreatedAt(toBeUpdated.getCreatedAt());
        Product updated = productRepository.save(model);
        return productMapper.toDto(updated);
    }

    @Override
    public ProductDto addReviewToProduct(Long productId, Long reviewId) {
        // Go to Reviews or Questions to have explanation
        ProductDto reviewToUpdate = findById(productId);
        List<Long> newReviewIds = new ArrayList<>(reviewToUpdate.getReviewIds());
        newReviewIds.add(reviewId);

        reviewToUpdate.setReviewIds(newReviewIds);
        CreateProductDto createDto = productMapper.fromDtoToCreateDto(reviewToUpdate);
        return updateById(productId, createDto);
    }

    @Override
    public ProductDto addQuestionToProduct(Long productId, Long questionId) {
        // Go to Reviews or Questions to have explanation
        ProductDto productToUpdate = findById(productId);
        List<Long> newQuestionIds = new ArrayList<>(productToUpdate.getQuestionIds());
        newQuestionIds.add(questionId);
        productToUpdate.setQuestionIds(newQuestionIds);
        CreateProductDto createDto = productMapper.fromDtoToCreateDto(productToUpdate);
        return updateById(productId, createDto);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
