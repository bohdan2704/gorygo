package com.example.gorygo.repository;

import com.example.gorygo.model.Question;
import com.example.gorygo.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
