package com.example.gorygo.model;

import com.example.gorygo.info.StaticValues;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="responses")
public class Response {
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
//    @OneToMany
//    private List<Response> responses;

    public Response(Long id) {
        this.id = id;
    }
}