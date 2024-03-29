package com.example.gorygo.dto.post;

import com.example.gorygo.model.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public record CreateProductDto(
        @NotBlank
        @Size(max = 100)
        String naming,
        List<Long> sizeIds,
        @NotBlank
        @Size(max = 2000)
        String description,
        @Positive
        BigDecimal price,
        List<Long> imageIds,
        Long categoryId,
        List<Long> reviewIds,
        List<Long> questionIds
) {}
