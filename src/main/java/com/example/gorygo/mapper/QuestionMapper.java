package com.example.gorygo.mapper;

import com.example.gorygo.dto.get.QuestionDto;
import com.example.gorygo.dto.post.CreateQuestionDto;
import com.example.gorygo.model.Question;
import com.example.gorygo.model.Response;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(config = MapperConfig.class, uses = UserMapper.class)
public interface QuestionMapper {
    @Mapping(target = "responseIds", ignore = true)
    @Mapping(target = "authorId", source = "author.id")
    QuestionDto toDto(Question question);

    @AfterMapping
    default void initIdsFromResponses(@MappingTarget QuestionDto dto,
                                     Question model) {
        List<Long> responseIds = model.getResponses()
                .stream()
                .map(Response::getId)
                .toList();
        dto.setResponseIds(responseIds);
    }

    @Mapping(target = "responses", ignore = true)
    @Mapping(target = "author", source = "authorId", qualifiedByName = "userFromId")
    Question toModel(CreateQuestionDto createQuestionDto);

    @AfterMapping
    default void initSubjectsFromIds(@MappingTarget Question model,
                                     CreateQuestionDto createDto) {
        List<Response> responseDummies = createDto.responseIds()
                .stream()
                .map(Response::new)
                .toList();
        model.setResponses(responseDummies);
    }

    CreateQuestionDto fromDtoToCreateDto(QuestionDto dto);
}
