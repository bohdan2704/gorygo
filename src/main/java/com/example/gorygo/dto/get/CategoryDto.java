package com.example.gorygo.dto.get;

import com.example.gorygo.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CategoryDto(
        Long id,
        String name,
//        Long imageId,
        Long upperId
//        List<Long> bottomIds
) {}
