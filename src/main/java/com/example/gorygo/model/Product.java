//package com.example.gorygo.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Positive;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@Table(name="product")
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @NotBlank
//    @Size(max = 100)
//    private String naming;
//    @OneToMany
//    private List<ProductSize> size;
//    @NotBlank
//    @Size(max = 2000)
//    private String description;
//    @Positive
//    private BigDecimal price;
//    @OneToMany
//    private List<Image> images;
//    @ManyToOne
//    private Category category;
//    @OneToMany
//    private List<Statement> reviews;
//    @OneToMany
//    private List<Statement> questions;
//}
//
