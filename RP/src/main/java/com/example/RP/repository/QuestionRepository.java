package com.example.RP.repository;

import com.example.RP.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {
    List<Questions> findByQuestionByCategory(String category);


}
