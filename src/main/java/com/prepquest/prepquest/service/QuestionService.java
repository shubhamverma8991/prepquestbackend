package com.prepquest.prepquest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prepquest.prepquest.model.Question;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Service
public class QuestionService {

    @PersistenceContext
    private EntityManager entityManager;

    // Method to get questions from the specified language table
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Question> getQuestionsByLanguage(String languageName, int page, int size) {
        String tableName = languageName.toLowerCase();
        System.out.println("pageaja: " + page + " " + size);

        // Use native SQL query and map directly to Question entity
        String queryString = "SELECT id, question, askedincompany, language_id, content FROM " + tableName + 
                             " ORDER BY id OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY";

        System.out.println("Executing SQL: " + queryString);
        try {
            Query query = entityManager.createNativeQuery(queryString, Question.class);
            query.setParameter("size", size);
            query.setParameter("offset", page * size);

            // Using native query, directly map to Question entity
            List<Question> questions = query.getResultList();

            return questions;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving questions from table: " + tableName, e);
        }
    }
}
