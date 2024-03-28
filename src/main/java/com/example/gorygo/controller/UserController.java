package com.example.gorygo.controller;

import com.example.gorygo.dto.get.UserDto;
import com.example.gorygo.dto.post.CreateUserDto;
import com.example.gorygo.model.User;
import com.example.gorygo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody @Valid CreateUserDto user) {
        return userService.save(user);
    }

    @PutMapping(path = "/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody @Valid CreateUserDto user) {
        return userService.updateById(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
