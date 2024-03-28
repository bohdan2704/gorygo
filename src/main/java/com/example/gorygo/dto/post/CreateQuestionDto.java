package com.example.gorygo.dto.post;

import com.example.gorygo.info.StaticValues;
import com.example.gorygo.model.Response;
import com.example.gorygo.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreateQuestionDto (
    @Size(max = StaticValues.BIG_TEXT_SIZE)
    String text,
    Long authorId
) {}
