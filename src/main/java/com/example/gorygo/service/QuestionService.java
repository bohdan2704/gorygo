package com.example.gorygo.service;

import com.example.gorygo.model.Question;
import com.example.gorygo.model.Response;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    Question save(Question question);

    Question findById(Long id);

    List<Question> findAll(Pageable pageable);

    Question updateById(Long id, Question question);

    void deleteById(Long id);
}
