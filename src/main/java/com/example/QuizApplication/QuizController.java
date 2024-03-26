package com.example.QuizApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("questions")
public class QuizController {
    @GetMapping("/allQuestions")
    public String getAllQuestions(){
        return "this page is for the questions being generaated";
    }
}
