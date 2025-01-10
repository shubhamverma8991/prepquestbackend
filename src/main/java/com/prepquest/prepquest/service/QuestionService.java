package com.prepquest.prepquest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prepquest.prepquest.model.TheoryQuestion;

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
    public List<TheoryQuestion> getQuestionsByLanguage(String languageName, int page, int size) {
        String tableName = languageName.toLowerCase();
        System.out.println("pageaja: " + page + " " + size);

        // Use native SQL query and map directly to Question entity
        // String queryString = "SELECT id, question, askedincompany, language_id, content FROM " + tableName + 
        //                      " ORDER BY id OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY";
        String queryString = "SELECT q FROM TheoryQuestion q JOIN q.language l WHERE LOWER(l.name) = LOWER(:languageName) ORDER BY q.id";

        System.out.println("Executing SQL: " + queryString);
        try {
            Query query = entityManager.createQuery(queryString, TheoryQuestion.class);
            query.setParameter("languageName", languageName);
            query.setFirstResult(page * size);
            query.setMaxResults(size);

            // Using native query, directly map to Question entity
            List<TheoryQuestion> questions = query.getResultList();

            return questions;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving questions from table: " + tableName, e);
        }
    }
}
