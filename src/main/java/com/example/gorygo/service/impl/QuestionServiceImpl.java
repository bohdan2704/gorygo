package com.example.gorygo.service.impl;

import com.example.gorygo.model.Question;
import com.example.gorygo.model.Response;
import com.example.gorygo.repository.QuestionRepository;
import com.example.gorygo.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable).stream().toList();
    }

    @Override
    public Question updateById(Long id, Question question) {
        question.setId(id);
        return questionRepository.save(question);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}
