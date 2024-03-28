package com.example.gorygo.model;

import com.example.gorygo.info.StaticValues;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;

@Entity
@Getter
@Setter
@Table(name="responses")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = StaticValues.LARGE_TEXT_SIZE)
    private String text;
    private LocalDateTime createdAt;
    @ManyToOne
    private User author;
//    @OneToMany
//    private List<Response> responses;
}