package com.example.gorygo.dto.get;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReviewDto {
        private Long id;
        String text;
        private Integer stars;
        Long authorId;
        private List<Long> responseIds;
}
