//package com.example.gorygo.controller;
//
//import com.example.gorygo.dto.get.ResponseDto;
//import com.example.gorygo.dto.post.CreateResponseDto;
//import com.example.gorygo.mapper.QuestionMapper;
//import com.example.gorygo.mapper.ResponseMapper;
//import com.example.gorygo.model.Response;
//import com.example.gorygo.service.QuestionService;
//import com.example.gorygo.service.ResponseService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Pageable;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/questions")
//@RequiredArgsConstructor
//public class QuestionController {
//    private final QuestionService questionService;
//    private final QuestionMapper questionMapper;
//
//    @GetMapping
//    public List<ResponseDto> getAllResponses(Pageable pageable) {
//        return questionService.findAll(pageable)
//                .stream()
//                .map(questionMapper::toDto)
//                .toList();
//    }
//
//    @GetMapping(path = "/{id}")
//    public ResponseDto getResById(@PathVariable Long id) {
//        return responseMapper.toDto(responseService.findById(id));
//    }
//
//    @PostMapping
//    public ResponseDto createRes(@RequestBody @Valid CreateResponseDto res) {
//        Response saved = responseService.save(responseMapper.toModel(res));
//        return responseMapper.toDto(saved);
//    }
//
//    @PutMapping(path = "/{id}")
//    public ResponseDto updRes(@PathVariable Long id, @RequestBody @Valid CreateResponseDto res) {
//        Response model = responseMapper.toModel(res);
//        model.setId(id);
//        responseService.updateById(id, model);
//        return responseMapper.toDto(model);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        responseService.deleteById(id);
//    }
//}
