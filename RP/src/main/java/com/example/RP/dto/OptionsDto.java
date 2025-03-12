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
    private List<QuestionsDto> nestedQuestions;
}
