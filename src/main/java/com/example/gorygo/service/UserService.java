package com.example.gorygo.service;

import com.example.gorygo.dto.get.UserDto;
import com.example.gorygo.dto.post.CreateUserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDto save(CreateUserDto createUserDto);

    UserDto findById(Long id);

    List<UserDto> findAll(Pageable pageable);

    UserDto updateById(Long id, CreateUserDto createUserDto);

    void deleteById(Long id);
}
