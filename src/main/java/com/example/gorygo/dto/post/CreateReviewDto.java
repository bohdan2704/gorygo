package com.example.gorygo.dto.post;

import com.example.gorygo.info.StaticValues;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;


public record CreateReviewDto(
        @NotBlank
        @Size(max = StaticValues.BIG_TEXT_SIZE)
        String text,
        @Positive
        @Max(value = 5)
        Integer stars,
        @NotNull
        Long authorId,
        @NotNull
        List<Long> responseIds
) {}
