package com.prepquest.prepquest.service;

import org.springframework.stereotype.Service;

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
    @SuppressWarnings("unchecked")
    public List<Question> getQuestionsByLanguage(String languageName, int page, int size) {
        String tableName = languageName.toLowerCase();
        System.out.println("pageaja: " + page + size);

        String queryString = "SELECT * FROM " + tableName + " ORDER BY id OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY";

        System.out.println("Executing SQL: " + queryString);
        try {
            Query query = entityManager.createNativeQuery(queryString, Question.class);
            query.setParameter("size", size);
            query.setParameter("offset", page * size);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving questions from table: " + tableName, e);
        }
    }
}
