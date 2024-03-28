package com.example.gorygo.dto.post;

import com.example.gorygo.info.StaticValues;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserDto(
        @NotBlank
        @Size(max = StaticValues.SMALL_TEXT_SIZE)
        String name,
        @NotNull
        @Pattern(regexp = StaticValues.EMAIL_PATTERN)
        String email
) {}
