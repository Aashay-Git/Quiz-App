package com.example.quiz_app.dto;

import java.util.List;

public class QuestionDTO {
    private int id;
    private String question;
    private List<String> options;

    public QuestionDTO(int id, String question, List<String> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
