package com.example.gorygo.service;

import com.example.gorygo.dto.get.QuestionDto;
import com.example.gorygo.dto.post.CreateQuestionDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    QuestionDto save(CreateQuestionDto question);

    QuestionDto findById(Long id);

    List<QuestionDto> findAll(Pageable pageable);

    QuestionDto updateById(Long id, CreateQuestionDto question);

    QuestionDto updateQuestionAddResponse(Long questionId, Long responseId);

    void deleteById(Long id);
}
