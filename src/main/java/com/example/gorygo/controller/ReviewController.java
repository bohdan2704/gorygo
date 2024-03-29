package com.example.gorygo.controller;

import com.example.gorygo.dto.get.QuestionDto;
import com.example.gorygo.dto.get.ResponseDto;
import com.example.gorygo.dto.get.ReviewDto;
import com.example.gorygo.dto.post.CreateQuestionDto;
import com.example.gorygo.dto.post.CreateResponseDto;
import com.example.gorygo.dto.post.CreateReviewDto;
import com.example.gorygo.mapper.QuestionMapper;
import com.example.gorygo.mapper.ResponseMapper;
import com.example.gorygo.model.Question;
import com.example.gorygo.model.Response;
import com.example.gorygo.service.QuestionService;
import com.example.gorygo.service.ResponseService;
import com.example.gorygo.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> getAllResponses(Pageable pageable) {
        return reviewService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public ReviewDto getQuestionById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @PostMapping
    public ReviewDto createQuestion(@RequestBody @Valid CreateReviewDto questionDto) {
        return reviewService.save(questionDto);
    }

    @PutMapping(path = "/{id}")
    public ReviewDto update(@PathVariable Long id, @RequestBody @Valid CreateReviewDto r) {
        return reviewService.updateById(id, r);
    }

    @PutMapping(path = "/{question_id}/{res_id}")
    public ReviewDto update(@PathVariable Long question_id, @PathVariable Long res_id) {
        return reviewService.updateQuestionAddResponse(question_id, res_id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
}
