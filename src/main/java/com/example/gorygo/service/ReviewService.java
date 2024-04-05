package com.example.gorygo.service;

import com.example.gorygo.dto.get.QuestionDto;
import com.example.gorygo.dto.get.ReviewDto;
import com.example.gorygo.dto.post.CreateQuestionDto;
import com.example.gorygo.dto.post.CreateReviewDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewService {
    ReviewDto save(CreateReviewDto question);

    ReviewDto findById(Long id);

    List<ReviewDto> findAll(Pageable pageable);

    ReviewDto updateById(Long id, CreateReviewDto question);

    ReviewDto updateQuestionAddResponse(Long questionId, Long responseId);

    void deleteById(Long id);

    List<ReviewDto> findAllByIds(List<Long> list);
}
