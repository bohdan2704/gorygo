package com.example.gorygo.controller;

import com.example.gorygo.dto.get.ProductDto;
import com.example.gorygo.dto.get.QuestionDto;
import com.example.gorygo.dto.post.CreateProductDto;
import com.example.gorygo.dto.post.CreateQuestionDto;
import com.example.gorygo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAllResponses(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public ProductDto getQuestionById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public ProductDto createQuestion(@RequestBody @Valid CreateProductDto createProductDto) {
        return productService.save(createProductDto);
    }

    @PutMapping(path = "/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody @Valid CreateProductDto productDto) {
        return productService.updateById(id, productDto);
    }

    @PutMapping(path = "/{product_id}/add-review/{review_id}")
    public ProductDto addReviewToProduct(@PathVariable Long product_id, @PathVariable Long review_id) {
        return productService.addReviewToProduct(product_id, review_id);
    }

        @PutMapping(path = "/{product_id}/add-question/{question_id}")
    public ProductDto addQuestionToProduct(@PathVariable Long product_id, @PathVariable Long question_id) {
        return productService.addQuestionToProduct(product_id, question_id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
