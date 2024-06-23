package com.example.demo.controller;

import com.example.demo.model.Questions;
import com.example.demo.model.UserSession;
import com.example.demo.servicelayer.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private UserSession userSession;

    @Autowired
    private Util util;

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        if (userSession.getUsername() == null) {
            return "redirect:/login";
        }

        Map<String, Integer> grades = (Map<String, Integer>) session.getServletContext().getAttribute("grades");
        if (grades == null) {
            grades = new HashMap<>();
            session.getServletContext().setAttribute("grades", grades);
        }

        boolean quizTaken = grades.containsKey(userSession.getUsername());
        model.addAttribute("username", userSession.getUsername());
        model.addAttribute("quizTaken", quizTaken);

        return "home";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        userSession.setUsername(username); // Set username in session
        userSession.setQuizTaken(false); // Reset quiz state
        return "redirect:/"; // Redirect to home page
    }

    @GetMapping("/logout")
    public String logout() {
        userSession.setUsername(null); // Clear username
        return "redirect:/login"; // Redirect to login page after logout
    }

    @GetMapping("/q")
    public String showQuiz(Model model) {
        if (userSession.getUsername() == null) return "redirect:/login";
        List<Questions> questions = util.getRandomizedQuestions();
        model.addAttribute("questions", questions);
        return "q";
    }

    @GetMapping("/grade")
    public String showGrades(Model model) {
        if (userSession.getUsername() == null) return "redirect:/login";
        return "grade";
    }
}
