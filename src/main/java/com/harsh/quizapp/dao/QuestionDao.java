package com.harsh.quizapp.dao;

import com.harsh.quizapp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDao extends JpaRepository<Questions,Integer> {

    List<Questions> findByCategory(String category);
    @Query(value="Select * From questions q where q.category=:category Order By Rand() Limit :numQ",nativeQuery = true)
    List<Questions> findRandomQuestionByCategory(String category, int numQ);
}
