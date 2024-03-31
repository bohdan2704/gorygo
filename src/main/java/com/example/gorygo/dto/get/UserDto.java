package com.example.gorygo.dto.get;

import java.time.LocalDateTime;

public record UserDto(
    Long id,
    String name,
    String email,
    LocalDateTime registeredAt
) {}
