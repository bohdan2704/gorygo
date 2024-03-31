package com.example.gorygo.dto.get;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ReviewDto {
        private Long id;
        String text;
        private Integer stars;
        LocalDateTime createdAt;
        Long authorId;
        private List<Long> responseIds;
}
