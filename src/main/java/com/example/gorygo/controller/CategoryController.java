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
        List<CategoryDto> allCategories = categoryService.findAll(pageable)
                .stream()
                .map(categoryMapper::toDto)
                .toList();

        // Finish initializing each category in a list above with a subcategory list
        for (var category : allCategories) {
            List<Category> subCategories = categoryService.getAllSubcategoriesOfCategoryById(category.getId());

            // Map list of retrieved categories to list of their ids
            List<Long> subCategoriesIds = subCategories
                    .stream()
                    .map(Category::getId)
                    .toList();
            category.setBottomIds(subCategoriesIds);
        }
        return allCategories;
    }

//    @GetMapping("/sub/{id}")
//    public List<CategoryDto> getAllSubcategories(@PathVariable Long id) {
//        return categoryService.getAllSubcategoriesOfCategoryById(id).stream().map(categoryMapper::toDto).toList();
//    }

    @GetMapping(path = "/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) {
        CategoryDto dto = categoryMapper.toDto(categoryService.findById(id));

        // Finish initialization of an object from DB with a list of subcategories
        List<Category> subCategories = categoryService.getAllSubcategoriesOfCategoryById(id);
        List<Long> subCategoriesIds = subCategories.stream().map(Category::getId).toList();
        dto.setBottomIds(subCategoriesIds);
        return dto;
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
