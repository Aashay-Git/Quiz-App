package com.example.quiz_app.dto;

import java.util.Map;

public class QuizSubmissionDTO {
    private Map<Integer, String> answers;

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, String> answers) {
        this.answers = answers;
    }
}
