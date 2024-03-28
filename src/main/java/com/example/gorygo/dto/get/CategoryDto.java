package com.example.gorygo.dto.get;

import com.example.gorygo.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;
    private Long upperId;
    private List<Long> bottomIds;
}
