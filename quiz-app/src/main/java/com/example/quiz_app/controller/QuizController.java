package com.example.quiz_app.controller;

import com.example.quiz_app.dto.QuestionDTO;
import com.example.quiz_app.dto.QuizResultDTO;
import com.example.quiz_app.dto.QuizSubmissionDTO;
import com.example.quiz_app.model.QuizQuestion;
import com.example.quiz_app.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/all-questions")
    public ResponseEntity<List<QuestionDTO>> getQuestions() {
        return new ResponseEntity<>(quizService.getAllQuestions(), HttpStatus.OK);
    }

    @PostMapping("/submit")
    public ResponseEntity<QuizResultDTO> submitQuiz(@RequestBody QuizSubmissionDTO submission) {
        return new ResponseEntity<>(quizService.calculateScore(submission.getAnswers()), HttpStatus.OK);
    }

    @PostMapping("/add-question")
    public ResponseEntity<String> addQuestion(@RequestBody QuizQuestion question) {
        quizService.addQuestion(question);
        return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
    }
}
