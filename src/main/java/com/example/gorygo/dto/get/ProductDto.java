package com.example.gorygo.dto.get;

import com.example.gorygo.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String naming;
    private String description;
    private BigDecimal price;
    private BigDecimal priceEuro;
    private LocalDateTime createdAt;
    private Long categoryId;
    private List<Long> sizeIds;
    private List<Long> imageIds;
    private List<Long> reviewIds;
    private List<Long> questionIds;
}
