package com.example.gorygo.mapper;

import com.example.gorygo.dto.get.QuestionDto;
import com.example.gorygo.dto.get.ReviewDto;
import com.example.gorygo.dto.post.CreateQuestionDto;
import com.example.gorygo.dto.post.CreateReviewDto;
import com.example.gorygo.model.Question;
import com.example.gorygo.model.Response;
import com.example.gorygo.model.Review;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapperConfig.class, uses = UserMapper.class)
public interface ReviewMapper {
    @Mapping(target = "responseIds", ignore = true)
    @Mapping(target = "authorId", source = "author.id")
    ReviewDto toDto(Review question);

    @AfterMapping
    default void initIdsFromResponses(@MappingTarget ReviewDto dto,
                                     Review model) {
        List<Long> responseIds = model.getResponses()
                .stream()
                .map(Response::getId)
                .toList();
        dto.setResponseIds(responseIds);
    }

    @Mapping(target = "responses", ignore = true)
    @Mapping(target = "author", source = "authorId", qualifiedByName = "userFromId")
    Review toModel(CreateReviewDto createReviewDto);

    @AfterMapping
    default void initSubjectsFromIds(@MappingTarget Review model,
                                     CreateReviewDto createDto) {
        List<Response> responseDummies = createDto.responseIds()
                .stream()
                .map(Response::new)
                .toList();
        model.setResponses(responseDummies);
    }

    CreateReviewDto fromDtoToCreateDto(ReviewDto dto);
}
