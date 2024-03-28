package com.example.gorygo.model;

import com.example.gorygo.info.StaticValues;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = StaticValues.SMALL_TEXT_SIZE)
    private String name;
    @Pattern(regexp = StaticValues.EMAIL_PATTERN) // message = "{invalid.email}")
    private String email;

    public User(Long id) {
        this.id = id;
    }
}