package com.example.RP.service;


import com.example.RP.entity.Questions;
import com.example.RP.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public List<Questions> getAllQuestions(String category) {
        List<Questions> questions;

        if (category == null) {
            return questionRepository.findAll();
        } else {
            questions = questionRepository.findByQuestionCategory(category);
        }
        System.out.println("Fetched Questions:");
        for (Questions q : questions) {
            System.out.println("ID: " + q.getId() + ", question_no: " + q.getQuestionNo() + ", Question: " + q.getQuestion() + ", question_category: " + q.getQuestionCategory() + ", is_nested_ques_avlbl: " + q.getIsNestedQuesAvlbl());
        }
        return questions;

    }
}
