package com.example.gorygo.service.impl;

import com.example.gorygo.model.Response;
import com.example.gorygo.model.Review;
import com.example.gorygo.repository.ReviewRepository;
import com.example.gorygo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable).stream().toList();
    }

    @Override
    public Review updateById(Long id, Review review) {
        review.setId(id);
        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
