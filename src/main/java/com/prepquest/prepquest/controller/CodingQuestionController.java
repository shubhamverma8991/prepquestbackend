package com.prepquest.prepquest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prepquest.prepquest.model.CodingQuestion;
import com.prepquest.prepquest.service.CodingQuestionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/codequestions")
public class CodingQuestionController {
    @Autowired
    private CodingQuestionService codingQuestionService;

    // Get questions by language
    @GetMapping("/{languageName}")
    public ResponseEntity<?> getQuestions(@PathVariable String languageName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        try {
            List<CodingQuestion> questions = codingQuestionService.getCodingQuestionsByLanguage(languageName, page, size);
            if (questions.isEmpty()) {
                return ResponseEntity.ok(Map.of("message", "No Questions Present", "data", new Object[]{}));
            }
            return ResponseEntity.ok(Map.of("message", "Questions Retrieved", "data", questions));
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(500).body(Map.of("error", "Internal Server Error", "message", e.getMessage()));
        }
    }
}
