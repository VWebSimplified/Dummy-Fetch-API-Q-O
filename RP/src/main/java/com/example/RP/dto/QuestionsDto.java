package com.example.RP.dto;

import com.example.RP.entity.Options;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsDto {
    private int id;
    private int questionNo;
    private String question;
    private String questionCategory;
    private Boolean isNestedQuesAvlbl;
    private List<OptionsDto> options;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(String questionCategory) {
        this.questionCategory = questionCategory;
    }

    public Boolean getIsNestedQuesAvlbl() {
        return isNestedQuesAvlbl;
    }

    public void setIsNestedQuesAvlbl(Boolean nestedQuesAvlbl) {
        isNestedQuesAvlbl = nestedQuesAvlbl;
    }

    public List<OptionsDto> getOptions() {
        return options;
    }

    public void setOptions(List<OptionsDto> options) {
        this.options = options;
    }
}
