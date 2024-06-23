package com.example.demo.model;

import java.util.List;

public class Questions {
    private String questionContent;
    private List<String> choices;
    private int correctAnswerIndex;


    public Questions(String questionContent, List<String> choices, int correctAnswerIndex) {
        this.questionContent = questionContent;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public List<String> getChoices() {
        return choices;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}