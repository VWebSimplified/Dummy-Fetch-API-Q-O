package com.example.RP.controller;


import com.example.RP.dto.QuestionsDto;
import com.example.RP.entity.Questions;
import com.example.RP.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping
    public List<QuestionsDto> getAllQuestions() {
        return questionService.getAllQuestions();
    }


    @GetMapping(params = "category")
    public List<QuestionsDto> getQuestionsByCategory(@RequestParam String category) {
        return questionService.getQuestionByCategory(category);
    }


}
