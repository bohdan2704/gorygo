package com.example.gorygo.mapper;

import com.example.gorygo.dto.get.UserDto;
import com.example.gorygo.dto.post.CreateUserDto;
import com.example.gorygo.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserDto toDto(User user);

    User toModel(CreateUserDto createBookDto);
}
