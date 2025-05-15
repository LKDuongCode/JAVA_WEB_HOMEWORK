package com.duong.ss08.controller;

import com.duong.ss08.model.Hw07_Question;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class Hw07_QuizController {

    private List<Hw07_Question> questions = new ArrayList<>();

    public Hw07_QuizController() {
        Hw07_Question q1 = new Hw07_Question();
        q1.setId(1);
        q1.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Apples_on_tree_2011_G1.jpg/500px-Apples_on_tree_2011_G1.jpg");
        q1.setAnswer("apple");

        Hw07_Question q2 = new Hw07_Question();
        q2.setId(2);
        q2.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/1/18/Dog_Breeds.jpg");
        q2.setAnswer("dog");

        Hw07_Question q3 = new Hw07_Question();
        q3.setId(3);
        q3.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Toyota_Fortuner_4x4_Legender_%28LTD%29_2-Tone_White_Pearl-Black.jpg/500px-Toyota_Fortuner_4x4_Legender_%28LTD%29_2-Tone_White_Pearl-Black.jpg");
        q3.setAnswer("car");

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
    }

    @GetMapping("/hw07/quiz")
    public String showQuiz(Model model, HttpSession session) {
        Random rand = new Random();
        Hw07_Question randomQuestion = questions.get(rand.nextInt(questions.size()));

        session.setAttribute("currentQuestion", randomQuestion);
        session.setAttribute("attempts", 0);

        model.addAttribute("question", randomQuestion);
        model.addAttribute("message", "");
        model.addAttribute("gameOver", false);
        return "hw07_quiz";
    }

    @PostMapping("/hw07/guess")
    public String guessAnswer(@RequestParam("answer") String answer, Model model, HttpSession session) {
        Hw07_Question currentQuestion = (Hw07_Question) session.getAttribute("currentQuestion");
        Integer attempts = (Integer) session.getAttribute("attempts");

        if (currentQuestion == null || attempts == null) {
            return "redirect:/hw07/quiz";
        }

        attempts++;
        session.setAttribute("attempts", attempts);

        if (answer.trim().equalsIgnoreCase(currentQuestion.getAnswer())) {
            model.addAttribute("message", "Đã đoán đúng!");
            model.addAttribute("gameOver", true);
        } else if (attempts >= 3) {
            model.addAttribute("message", "Bạn hết lượt đoán. Đáp án đúng là: " + currentQuestion.getAnswer());
            model.addAttribute("gameOver", true);
        } else {
            model.addAttribute("message", "Sai rồi, thử lại nhé! (Lượt đoán: " + attempts + "/3)");
            model.addAttribute("gameOver", false);
        }

        model.addAttribute("question", currentQuestion);
        return "hw07_quiz";
    }
}