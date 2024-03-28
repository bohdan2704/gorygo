package com.example.gorygo.dto.post;

import jakarta.persistence.ManyToOne;

public record CreateResponseDto(
        String text,
        Long authorId
) {}
