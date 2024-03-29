package com.example.gorygo.dto.post;

import com.example.gorygo.info.StaticValues;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;


public record CreateReviewDto(
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
