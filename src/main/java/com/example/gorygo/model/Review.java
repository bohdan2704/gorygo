package com.example.gorygo.model;

import com.example.gorygo.info.StaticValues;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = StaticValues.LARGE_TEXT_SIZE)
    private String text;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @ManyToOne
    private User author;
    @Positive
    @Max(value = 5)
    private Integer stars;
    @OneToMany
    private List<Response> responses;

    public Review(Long id) {
        this.id = id;
    }
}