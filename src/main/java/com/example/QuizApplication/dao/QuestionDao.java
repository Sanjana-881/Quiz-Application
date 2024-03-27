package com.example.QuizApplication.dao;

import com.example.QuizApplication.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);
}
