package com.example.gorygo.dto.get;

import com.example.gorygo.info.StaticValues;
import com.example.gorygo.model.Response;
import com.example.gorygo.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDto {
        private Long id;
        String text;
        Long authorId;
        private List<Long> responseIds;
}
