package com.example.gorygo.controller;

import com.example.gorygo.dto.get.CategoryDto;
import com.example.gorygo.dto.post.CreateCategoryDto;
import com.example.gorygo.mapper.CategoryMapper;
import com.example.gorygo.model.Category;
import com.example.gorygo.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getAllCategories(Pageable pageable) {
        return categoryService.findAll(pageable).stream().map(categoryMapper::toDto).toList();
    }

    @GetMapping("/sub/{id}")
    public List<CategoryDto> getAllSubcategories(@PathVariable Long id) {
        return categoryService.getAllSubcategoriesOfCategoryById(id).stream().map(categoryMapper::toDto).toList();
    }

    @GetMapping(path = "/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) {
        return categoryMapper.toDto(categoryService.findById(id));
    }

    @PostMapping
    public CategoryDto createCategory(@RequestBody @Valid CreateCategoryDto category) {
        Category model = categoryMapper.toModel(category);
        Category saved = categoryService.save(model);
        return categoryMapper.toDto(saved);
    }

    @PutMapping(path = "/{id}")
    public CategoryDto updateCategory(@PathVariable Long id, @RequestBody @Valid CreateCategoryDto category) {
        Category model = categoryMapper.toModel(category);
        Category updated = categoryService.updateById(id, model);
        return categoryMapper.toDto(updated);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
