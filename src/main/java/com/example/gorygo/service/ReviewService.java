package com.example.gorygo.service;

import com.example.gorygo.model.Response;
import com.example.gorygo.model.Review;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewService {
    Review save(Review review);

    Review findById(Long id);

    List<Review> findAll(Pageable pageable);

    Review updateById(Long id, Review review);

    void deleteById(Long id);
}
