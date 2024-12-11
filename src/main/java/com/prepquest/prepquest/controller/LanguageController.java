package com.prepquest.prepquest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import com.prepquest.prepquest.model.Language;
import com.prepquest.prepquest.service.LanguageService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    @Autowired
    public LanguageService languageService;

    @PersistenceContext
    private EntityManager entityManager;

    // Get All Language
    @GetMapping("/all")
    public ResponseEntity<?> getAllLang() {
        List<Language> language = languageService.getAllLang();
        if (language.isEmpty()) {
            return ResponseEntity.ok(Map.of("message", "No Language Present"));
        }
        return ResponseEntity.ok(language);
    }

    // Add Language
    @PostMapping("/addlanguage")
    @Transactional
    public ResponseEntity<?> addLang(@RequestBody Language lang) {
        try {
            languageService.saveLang(lang);
            System.out.println("language "+lang);
            
            // Create a new Table for the language
            String tableName = lang.getLanguageName().toLowerCase();
            String createTable = "CREATE TABLE " + tableName + " (" +
            "id BIGINT PRIMARY KEY IDENTITY(1,1), " +
            "question TEXT, " +
            "askedincompany VARCHAR(255), " +
            "language_id BIGINT, " +
            "content TEXT, " +
            "FOREIGN KEY (language_id) REFERENCES language(id) ON DELETE CASCADE" +
            ");";
        
            System.out.println("Executing SQL: " + createTable);

            // Execute the SQL to create the table
            entityManager.createNativeQuery(createTable).executeUpdate();
            
            return ResponseEntity.ok(Map.of("message", "Language Added"));
        } catch (Exception e) {
            // Log the exception (you can use a logger here)
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "An error occurred: " + e.getMessage()));
        }
    }

    
}
