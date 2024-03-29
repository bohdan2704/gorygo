package com.example.gorygo.controller;

import com.example.gorygo.dto.get.QuestionDto;
import com.example.gorygo.dto.get.ResponseDto;
import com.example.gorygo.dto.post.CreateQuestionDto;
import com.example.gorygo.dto.post.CreateResponseDto;
import com.example.gorygo.mapper.QuestionMapper;
import com.example.gorygo.mapper.ResponseMapper;
import com.example.gorygo.model.Question;
import com.example.gorygo.model.Response;
import com.example.gorygo.service.QuestionService;
import com.example.gorygo.service.ResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public List<QuestionDto> getAllResponses(Pageable pageable) {
        return questionService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public QuestionDto getQuestionById(@PathVariable Long id) {
        return questionService.findById(id);
    }

    @PostMapping
    public QuestionDto createQuestion(@RequestBody @Valid CreateQuestionDto questionDto) {
        return questionService.save(questionDto);
    }

    @PutMapping(path = "/{id}")
    public QuestionDto update(@PathVariable Long id, @RequestBody @Valid CreateQuestionDto q) {
        return questionService.updateById(id, q);
    }

    @PutMapping(path = "/{question_id}/{res_id}")
    public QuestionDto update(@PathVariable Long question_id, @PathVariable Long res_id) {
        return questionService.updateQuestionAddResponse(question_id, res_id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        questionService.deleteById(id);
    }
}
