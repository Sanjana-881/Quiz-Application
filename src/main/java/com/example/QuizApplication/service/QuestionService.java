package com.example.QuizApplication.service;

import com.example.QuizApplication.dao.QuestionDao;
import com.example.QuizApplication.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    //Getting Questions from the database
    public ResponseEntity<List<Question>> getAllQuestions() {

     try {
         return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
         }
     catch (Exception e) {
         e.printStackTrace();
     }
     return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    //Getting questions by category

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    //Adding Question to the database
    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
