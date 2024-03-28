package com.example.gorygo.dto.post;

import com.example.gorygo.model.Category;
import com.example.gorygo.model.Image;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateCategoryDto(
        @NotBlank
        String name,
//        @NotNull
//        Long imageId,
        Long upperId
//        List<Long> bottomIds
) {}
