package com.example.RP.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

@Entity
@Slf4j
@Getter
@Setter
@Table(name = "questions_table")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_no")
    private Integer questionNo;

    @Column(name = "question")
    private String question;

    @Column(name = "question_category")
    private String questionCategory;

    @Column(name = "is_nested_ques_avlbl")
    private Boolean isNestedQuesAvlbl;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference // Prevents infinite recursion
    private List<Options> options;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(Integer questionNo) {
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

    public Boolean getNestedQuesAvlbl() {
        return isNestedQuesAvlbl;
    }

    public void setNestedQuesAvlbl(Boolean nestedQuesAvlbl) {
        isNestedQuesAvlbl = nestedQuesAvlbl;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }
}
