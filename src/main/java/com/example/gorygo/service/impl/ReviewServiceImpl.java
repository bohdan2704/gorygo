package com.example.gorygo.service.impl;

import com.example.gorygo.dto.get.QuestionDto;
import com.example.gorygo.dto.get.ReviewDto;
import com.example.gorygo.dto.post.CreateQuestionDto;
import com.example.gorygo.dto.post.CreateReviewDto;
import com.example.gorygo.mapper.ReviewMapper;
import com.example.gorygo.model.Question;
import com.example.gorygo.model.Review;
import com.example.gorygo.repository.ReviewRepository;
import com.example.gorygo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewDto save(CreateReviewDto reviewDto) {
        Review model = reviewMapper.toModel(reviewDto);
//        model.setCreatedAt(LocalDateTime.now());
        Review saved = reviewRepository.save(model);
        return reviewMapper.toDto(saved);
    }

    @Override
    public ReviewDto findById(Long id) {
        return reviewRepository.findById(id).map(reviewMapper::toDto).orElseThrow();
    }

    @Override
    public List<ReviewDto> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable).stream().map(reviewMapper::toDto).toList();
    }

    @Override
    public ReviewDto updateById(Long id, CreateReviewDto question) {
        Review model = reviewMapper.toModel(question);
        model.setId(id);
        Review updated = reviewRepository.save(model);
        return reviewMapper.toDto(updated);
    }

    @Override
    public ReviewDto updateQuestionAddResponse(Long questionId, Long responseId) {
        ReviewDto questionToUpdate = findById(questionId);

        // Get an immutable list of Response Ids from dto, copy it
        List<Long> responseIds = new ArrayList<>(questionToUpdate.getResponseIds());
        // Add to a modifiable copy (our list) a new element
        responseIds.add(responseId);
        // Then set a modified list to our dto (erase prev)
        questionToUpdate.setResponseIds(responseIds);

        // Update dto with a modified list, so changes will go to DB
        CreateReviewDto createQuestionDto = reviewMapper.fromDtoToCreateDto(questionToUpdate);
        return updateById(questionId, createQuestionDto);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDto> findAllByIds(List<Long> list) {
        return reviewRepository.findAllById(list).stream().map(reviewMapper::toDto).toList();
    }
}
