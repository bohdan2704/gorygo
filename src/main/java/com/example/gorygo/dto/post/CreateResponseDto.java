package com.example.gorygo.dto.post;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateResponseDto(
        @NotBlank
        String text,
        @NotNull
        Long authorId
) {}
