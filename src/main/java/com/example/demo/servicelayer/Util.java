package com.example.demo.servicelayer;

import org.springframework.stereotype.Component;
import com.example.demo.model.Questions;

import java.util.*;

@Component
public class Util {

    private List<Questions> questions;

    public Util() {
        this.questions = new ArrayList<>();
        printQuestions();
    }

    private void printQuestions() {
        questions.add(new Questions("What is the Capital of South Korea?",
                Arrays.asList("Seoul", "Busan", "Jeju", "Incheon"), 0));
        questions.add(new Questions("What is the Country known as The Land of the Rising Sun?",
                Arrays.asList("China", "Philippines", "South Korea", "Japan"), 3));
        questions.add(new Questions("Which Planet is closest to the Sun?",
                Arrays.asList("Earth", "Mercury", "Mars", "Saturn"), 1));
        questions.add(new Questions("What is the Longest River in the World?",
                Arrays.asList("Amazon River", "Yangtze River", "Nile River", "Yellow River"), 2));
        questions.add(new Questions("What is the National Flower of the Philippines?",
                Arrays.asList("Sampaguita", "Gumamela", "Santan", "Ilang-Ilang"), 0));
    }

    public List<Questions> getRandomizedQuestions() {
        Collections.shuffle(questions);
        return new ArrayList<>(questions);
    }

    public int calculateScore(Map<Integer, Integer> answers) {
        int score = 0;
        for (Map.Entry<Integer, Integer> entry : answers.entrySet()) {
            int questionIndex = entry.getKey();
            int selectedAnswerIndex = entry.getValue();

            if (questionIndex >= 0 && questionIndex < questions.size()) {
                Questions question = questions.get(questionIndex);
                if (question.getCorrectAnswerIndex() == selectedAnswerIndex) {
                    score++;
                }
            }
        }
        return score;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}