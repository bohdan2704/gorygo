package com.example.gorygo.mapper;

import com.example.gorygo.dto.get.CategoryDto;
import com.example.gorygo.dto.get.ResponseDto;
import com.example.gorygo.dto.post.CreateCategoryDto;
import com.example.gorygo.dto.post.CreateResponseDto;
import com.example.gorygo.model.Category;
import com.example.gorygo.model.Response;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class, uses = UserMapper.class)
public interface ResponseMapper {
    @Mapping(target = "authorId", source = "author.id")
    ResponseDto toDto(Response response);

    @Mapping(target = "author", source = "authorId", qualifiedByName = "userFromId")
    Response toModel(CreateResponseDto createResponseDto);
}
