package com.example.RP.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "options_table")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "option_value")
    private String optionValue;

    @ManyToOne
    @JoinColumn(name = "ques_id", nullable = false)
    @JsonBackReference // Prevents infinite recursion
    private Questions question;

    @Column(name = "option_type")
    private String optionType;

    @Column(name = "score")
    private Integer score;

    @Column(name = "nested_ques_id")
    private Integer nestedQuesId;
}
