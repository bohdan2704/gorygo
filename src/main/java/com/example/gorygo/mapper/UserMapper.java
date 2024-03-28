package com.example.gorygo.mapper;

import com.example.gorygo.dto.get.UserDto;
import com.example.gorygo.dto.post.CreateUserDto;
import com.example.gorygo.model.Category;
import com.example.gorygo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserDto toDto(User user);

    User toModel(CreateUserDto createBookDto);

    @Named("userFromId")
    default User categoryFromId(Long id) {
        if (id != null) {
            return new User(id);
        }
        return null;
    }
}
