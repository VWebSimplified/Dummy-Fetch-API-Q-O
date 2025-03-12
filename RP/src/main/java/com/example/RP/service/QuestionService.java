package com.example.RP.service;


import com.example.RP.dto.OptionsDto;
import com.example.RP.dto.QuestionsDto;
import com.example.RP.entity.Options;
import com.example.RP.entity.Questions;
import com.example.RP.repository.OptionRepository;
import com.example.RP.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public  List<QuestionsDto> getAllQuestions(){
       List<Questions>   questionsList =   questionRepository.findAll();
       return convertToDtoList(questionsList);
    }
    public    List<QuestionsDto>   getQuestionByCategory(String category){
           List<Questions>  questionsByCategory =  questionRepository.findByQuestionByCategory(category);
           return convertToDtoList(questionsByCategory);
    }

      public List<QuestionsDto> convertToDtoList(List<Questions> questionsList){
             List<QuestionsDto> questionsDtoList = new ArrayList<>();

             for( Questions  question: questionsList ){
                 QuestionsDto questionsDto = new QuestionsDto();
                 questionsDto.setId(question.getId());
                 questionsDto.setQuestionNo(question.getQuestionNo());
                 questionsDto.setQuestion(question.getQuestion());
                 questionsDto.setQuestionCategory(question.getQuestionCategory());
                 questionsDto.setIsNestedQuesAvlbl(question.getIsNestedQuesAvlbl());

                 List<OptionsDto> optionsDtoList = new ArrayList<>();
                 for(  Options option : question.getOptions()){
                     OptionsDto optionsDto = new OptionsDto();
                     optionsDto.setId(option.getId());
                     optionsDto.setOptionValue(option.getOptionValue());
                     optionsDto.setOptionType(option.getOptionType());
                     optionsDto.setScore(option.getScore());

                     // We Will check if Option has Nested question, if yes then we will fetch it
                     if(option.getNestedQuesId()!=null){
                         for( Questions   nestedQuestion: questionsList){
                             if(nestedQuestion.getId().equals(option.getNestedQuesId().longValue())){
                                 QuestionsDto nestedDto = new QuestionsDto();
                                 nestedDto.setId(nestedQuestion.getId());
                                 nestedDto.setQuestionNo(nestedQuestion.getQuestionNo());
                                 nestedDto.setQuestion(nestedQuestion.getQuestion());
                                 nestedDto.setQuestionCategory(nestedQuestion.getQuestionCategory());
                                 nestedDto.setIsNestedQuesAvlbl(nestedQuestion.getIsNestedQuesAvlbl());

                                 // Adding nested question's options
                                  List<OptionsDto> nestedOptions = new ArrayList<>();
                                  for( Options  nestedOption:  nestedQuestion.getOptions()){
                                      OptionsDto nestedOptionDto = new OptionsDto();
                                      nestedOptionDto.setId(nestedOption.getId());
                                      nestedOptionDto.setOptionValue(nestedOption.getOptionValue());
                                      nestedOptionDto.setOptionType(nestedOption.getOptionType());
                                      nestedOptionDto.setScore(nestedOption.getScore());
                                      nestedOptions.add(nestedOptionDto);
                                  }
                                    nestedDto.setOptions(nestedOptions);

                                 // Add nested question to the option

                                 List<QuestionsDto> nestedQuestionsList = new ArrayList<>();
                                 nestedQuestionsList.add(nestedDto);
                                 optionsDto.setNestedQuestions(nestedQuestionsList);
                             }
                         }
                     }
                     optionsDtoList.add(optionsDto);
                 }

                 questionsDto.setOptions(optionsDtoList);
                 questionsDtoList.add(questionsDto);
             }
      return questionsDtoList;
    }

}
