package com.example.RP.dto;

import com.example.RP.entity.Questions;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class OptionsDto {
    private Long id;
    private String optionValue;
    private String optionType;
    private Integer score;
    private Long quesId;
    private List<QuestionsDto> nestedQuestions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<QuestionsDto> getNestedQuestions() {
        return nestedQuestions;
    }

    public void setNestedQuestions(List<QuestionsDto> nestedQuestions) {
        this.nestedQuestions = nestedQuestions;
    }

    public Long getQuesId() {
        return quesId;
    }

    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }
}
