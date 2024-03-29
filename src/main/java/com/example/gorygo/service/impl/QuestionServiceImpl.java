package com.example.gorygo.service.impl;

import com.example.gorygo.dto.get.QuestionDto;
import com.example.gorygo.dto.post.CreateQuestionDto;
import com.example.gorygo.mapper.QuestionMapper;
import com.example.gorygo.model.Question;
import com.example.gorygo.repository.QuestionRepository;
import com.example.gorygo.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Override
    public QuestionDto save(CreateQuestionDto question) {
        Question model = questionMapper.toModel(question);
        Question saved = questionRepository.save(model);
        return questionMapper.toDto(saved);
    }

    @Override
    public QuestionDto findById(Long id) {
        return questionRepository.findById(id).map(questionMapper::toDto).orElseThrow();
    }

    private Question findModelById(Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<QuestionDto> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable).stream().map(questionMapper::toDto).toList();
    }

    @Override
    public QuestionDto updateById(Long id, CreateQuestionDto question) {
        Question model = questionMapper.toModel(question);
        model.setId(id);
        Question updated = questionRepository.save(model);
        return questionMapper.toDto(updated);
    }

    @Override
    public QuestionDto updateQuestionAddResponse(Long questionId, Long responseId) {
        QuestionDto questionToUpdate = findById(questionId);
        // Get an immutable list and then copy it, to be able to add an element to that list
        List<Long> newResponseIds = new ArrayList<>(questionToUpdate.getResponseIds());
        newResponseIds.add(responseId);

        // Set our new list to object (erase prev immutable list)
        questionToUpdate.setResponseIds(newResponseIds);
        CreateQuestionDto createQuestionDto = questionMapper.fromDtoToCreateDto(questionToUpdate);
        return updateById(questionId, createQuestionDto);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}
