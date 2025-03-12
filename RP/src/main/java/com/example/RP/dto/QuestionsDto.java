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
    private Long id;
    private int questionNo;
    private String question;
    private String questionCategory;
    private Boolean isNestedQuesAvlbl;
    private List<OptionsDto> options;
}
