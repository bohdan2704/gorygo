package com.example.gorygo.controller;

import com.example.gorygo.model.Response;
import com.example.gorygo.service.ResponseService;
import com.example.gorygo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responses")
@RequiredArgsConstructor
public class ResponseController {
    private final ResponseService responseService;
    private final UserService userService;
    //    @RequestBody Statement statement
    @PostMapping
    public Response createResponse() {
//        User user = new User();
//        user.setName("Bohdan");
//        user.setEmail("gogolbohdan2005@gmail.com");
//        User save = userService.save(user);
//
//        User user2 = new User();
//        user2.setName("Denys");
//        user2.setEmail("denys_hohol@gmail.com");
//        User save1 = userService.save(user2);
//
//        Statement statement1 = new Statement();
//        statement1.setQuestion("What is the best route for a beginner hiker in the Carpathian mountains?");
//        statement1.setAuthor(user);
//
//        Statement statement2 = new Statement();
//        statement2.setQuestion("How difficult is the trek to Hoverla, the highest peak in Ukraine?");
//        statement2.setAuthor(user2);
//
//        statementService.save(statement1);
//        statementService.save(statement2);
//
//        List<Statement> responses = List.of(statement1, statement2);
//        Statement statement3 = new Statement();
//        statement3.setQuestion("Ofuget yakiy krutiy backpack");
//        statement3.setAuthor(user);
//        statement3.setResponses(responses);
//
//        return statementService.save(statement3);
        return null;
    }

}
