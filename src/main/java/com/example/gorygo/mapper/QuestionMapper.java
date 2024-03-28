//package com.example.gorygo.mapper;
//
//import com.example.gorygo.dto.get.QuestionDto;
//import com.example.gorygo.dto.get.ResponseDto;
//import com.example.gorygo.dto.post.CreateQuestionDto;
//import com.example.gorygo.dto.post.CreateResponseDto;
//import com.example.gorygo.model.Question;
//import com.example.gorygo.model.Response;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(config = MapperConfig.class, uses = UserMapper.class)
//public interface QuestionMapper {
//    @Mapping(target = "authorId", source = "author.id")
//    QuestionDto toDto(Response response);
//
//    @Mapping(target = "author", source = "authorId", qualifiedByName = "userFromId")
//    Question toModel(CreateQuestionDto createQuestionDto);
//}
