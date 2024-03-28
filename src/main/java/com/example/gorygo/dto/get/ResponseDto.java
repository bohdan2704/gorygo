package com.example.gorygo.dto.get;

import com.example.gorygo.info.StaticValues;
import com.example.gorygo.model.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record ResponseDto(
        Long id,
        String text,
        LocalDateTime createdAt,
        Long authorId
) {}
