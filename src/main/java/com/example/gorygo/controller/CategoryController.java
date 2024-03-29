package com.example.gorygo.controller;

import com.example.gorygo.dto.get.CategoryDto;
import com.example.gorygo.dto.post.CreateCategoryDto;
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

    @GetMapping
    public List<CategoryDto> getAllCategories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

//    @GetMapping("/sub/{id}")
//    public List<CategoryDto> getAllSubcategories(@PathVariable Long id) {
//        return categoryService.getAllSubcategoriesOfCategoryById(id).stream().map(categoryMapper::toDto).toList();
//    }

    @GetMapping(path = "/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public CategoryDto createCategory(@RequestBody @Valid CreateCategoryDto category) {
        return categoryService.save(category);
    }

    @PutMapping(path = "/{id}")
    public CategoryDto updateCategory(@PathVariable Long id, @RequestBody @Valid CreateCategoryDto category) {
        return categoryService.updateById(id, category);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
