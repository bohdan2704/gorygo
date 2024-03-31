package com.example.gorygo.dto.get;

import com.example.gorygo.info.StaticValues;
import com.example.gorygo.model.Response;
import com.example.gorygo.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class QuestionDto {
        private Long id;
        String text;
        private LocalDateTime createdAt;
        Long authorId;
        private List<Long> responseIds;
}
