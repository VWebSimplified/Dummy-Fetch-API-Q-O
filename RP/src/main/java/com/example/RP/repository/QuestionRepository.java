package com.example.RP.repository;

import com.example.RP.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Questions, Long> {
    List<Questions> findByQuestionCategory(String category);


}
