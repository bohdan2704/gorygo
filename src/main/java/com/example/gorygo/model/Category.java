package com.example.gorygo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
//    @ManyToOne
//    private Image image;
    @ManyToOne
    private Category upper;
//    @OneToMany
//    private List<Category> bottom;

    public Category(Long id) {
        this.id = id;
    }
}
