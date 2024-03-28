package com.example.gorygo.model;

import com.example.gorygo.info.StaticValues;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = StaticValues.BIG_TEXT_SIZE)
    private String text;
    @ManyToOne
    private User author;
    @OneToMany
    private List<Response> responses;
}