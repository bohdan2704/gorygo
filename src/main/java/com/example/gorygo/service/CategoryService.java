package com.example.gorygo.service;

import com.example.gorygo.model.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Category save(Category createCategoryDto);

    Category findById(Long id);

    List<Category> getAllSubcategoriesOfCategoryById(Long id);

    List<Category> findAll(Pageable pageable);

    Category updateById(Long id, Category createCategoryDto);

    void deleteById(Long id);
}
