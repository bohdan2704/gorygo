package com.example.gorygo.service.impl;

import com.example.gorygo.dto.get.CategoryDto;
import com.example.gorygo.dto.post.CreateCategoryDto;
import com.example.gorygo.mapper.CategoryMapper;
import com.example.gorygo.model.Category;
import com.example.gorygo.repository.CategoryRepository;
import com.example.gorygo.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto save(@Valid CreateCategoryDto category) {
        Category model = categoryMapper.toModel(category);
        Category saved = categoryRepository.save(model);
        return categoryMapper.toDto(saved);
    }

    @Override
    public CategoryDto findById(Long id) {
        CategoryDto categoryDto = categoryRepository.findById(id).map(categoryMapper::toDto).orElseThrow();

        // Finish initializing each category in a list above with a subcategory list
        List<CategoryDto> subCategories = getAllSubcategoriesOfCategoryById(categoryDto.getId());
        // Map list of retrieved categories to list of their ids
        List<Long> subCategoriesIds = subCategories
                .stream()
                .map(CategoryDto::getId)
                .toList();
        categoryDto.setBottomIds(subCategoriesIds);
        return categoryDto;
    }

    @Override
    public List<CategoryDto> getAllSubcategoriesOfCategoryById(Long id) {
        return categoryRepository.getCategoriesByUpper_Id(id)
                .stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    @Override
    public List<CategoryDto> findAll(Pageable pageable) {
        List<CategoryDto> allCategories = categoryRepository.findAll(pageable)
                .stream()
                .map(categoryMapper::toDto)
                .toList();

        // Finish initializing each category in a list above with a subcategory list
        for (var category : allCategories) {
            List<CategoryDto> subCategories = getAllSubcategoriesOfCategoryById(category.getId());

            // Map list of retrieved categories to list of their ids
            List<Long> subCategoriesIds = subCategories
                    .stream()
                    .map(CategoryDto::getId)
                    .toList();
            category.setBottomIds(subCategoriesIds);
        }
        return allCategories;
    }

    @Override
    public CategoryDto updateById(Long id, @Valid CreateCategoryDto category) {
        Category model = categoryMapper.toModel(category);
        model.setId(id);
        Category updated = categoryRepository.save(model);
        return categoryMapper.toDto(updated);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
