package com.example.gorygo.repository;

import com.example.gorygo.model.Image;
import com.example.gorygo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long>  {
    Image findByNaming(String name);
}
