package com.example.gorygo.service;

import com.example.gorygo.dto.get.CategoryDto;
import com.example.gorygo.dto.post.CreateCategoryDto;
import com.example.gorygo.model.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CreateCategoryDto createCategoryDto);

    CategoryDto findById(Long id);

    List<CategoryDto> getAllSubcategoriesOfCategoryById(Long id);

    List<CategoryDto> findAll(Pageable pageable);

    CategoryDto updateById(Long id, CreateCategoryDto createCategoryDto);

    void deleteById(Long id);
}
