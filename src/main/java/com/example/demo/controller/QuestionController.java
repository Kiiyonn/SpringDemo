package com.example.demo.controller;

import com.example.demo.model.UserSession;
import com.example.demo.servicelayer.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@Controller
public class QuestionController {

    @Autowired
    private UserSession userSession;

    @Autowired
    private Util util;

    @PostMapping("/q")
    public String submitQuiz(@RequestParam Map<String, String> allParams, Model model, HttpSession session) {
        if (userSession.getUsername() == null) return "redirect:/login";

        Map<Integer, Integer> answers = new HashMap<>();
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if (entry.getKey().startsWith("question_")) {
                int questionId = Integer.parseInt(entry.getKey().substring(9));
                int answerIndex = Integer.parseInt(entry.getValue());
                answers.put(questionId, answerIndex);
            }
        }

        int score = util.calculateScore(answers);
        Map<String, Integer> grades = (Map<String, Integer>) session.getServletContext().getAttribute("grades");
        if (grades == null) {
            grades = new HashMap<>();
            session.getServletContext().setAttribute("grades", grades);
        }
        grades.put(userSession.getUsername(), score);
        session.getServletContext().setAttribute("grades", grades);

        int totalQuestions = util.getTotalQuestions();
        double percentage = ((double) score / totalQuestions) * 100;

        model.addAttribute("score", score);
        model.addAttribute("percentage", percentage);
        model.addAttribute("totalQuestions", totalQuestions);

        return "result";
    }
}
