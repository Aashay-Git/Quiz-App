package com.example.quiz_app.service;

import com.example.quiz_app.dto.QuestionDTO;
import com.example.quiz_app.dto.QuizResultDTO;
import com.example.quiz_app.model.QuizQuestion;
import com.example.quiz_app.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<QuestionDTO> getAllQuestions() {
        List<QuizQuestion> questions = quizRepository.findAll();
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (QuizQuestion q : questions) {
            List<String> options = new ArrayList<>();
            options.add(q.getOptionA());
            options.add(q.getOptionB());
            options.add(q.getOptionC());
            options.add(q.getOptionD());
            questionDTOS.add(new QuestionDTO(q.getId(), q.getQuestion(), options));
        }
        return questionDTOS;
    }

    public void addQuestion(QuizQuestion question) {
        quizRepository.save(question);
    }

    public QuizResultDTO calculateScore(Map<Integer, String> answers) {
        int score = 0;
        List<QuizQuestion> allQuestions = quizRepository.findAll();
        int total = allQuestions.size();

        for (Integer id : answers.keySet()) {
            String userAnswer = answers.get(id);

            QuizQuestion question = quizRepository.findById(id);
            if (question != null) {
                if (question.getCorrectOption() != null && question.getCorrectOption().equalsIgnoreCase(userAnswer)) {
                    score++;
                }
            }
        }

        return new QuizResultDTO(score, total);
    }
}
