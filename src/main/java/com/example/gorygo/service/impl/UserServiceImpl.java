package com.example.gorygo.service.impl;

import com.example.gorygo.dto.get.UserDto;
import com.example.gorygo.dto.post.CreateUserDto;
import com.example.gorygo.mapper.UserMapper;
import com.example.gorygo.model.User;
import com.example.gorygo.repository.UserRepository;
import com.example.gorygo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(CreateUserDto user) {
        User toSave = userMapper.toModel(user);
        toSave.setRegisteredAt(LocalDateTime.now());
        userRepository.save(toSave);
        return userMapper.toDto(toSave);
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.map(userMapper::toDto).orElseThrow();
    }

    @Override
    public List<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).stream().map(userMapper::toDto).toList();
    }

    @Override
    public UserDto updateById(Long id, CreateUserDto user) {
        User toSave = userMapper.toModel(user);
        toSave.setId(id);
        toSave = userRepository.save(toSave);
        return userMapper.toDto(toSave);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
