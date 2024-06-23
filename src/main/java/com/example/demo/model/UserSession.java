package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {
    private String username;
    private boolean quizTaken;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isQuizTaken() {
        return quizTaken;
    }

    public void setQuizTaken(boolean quizTaken) {
        this.quizTaken = quizTaken;
    }
}
