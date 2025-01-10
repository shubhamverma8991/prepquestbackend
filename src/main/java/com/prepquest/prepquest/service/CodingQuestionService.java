package com.prepquest.prepquest.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prepquest.prepquest.model.CodingQuestion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Service
@Transactional
public class CodingQuestionService {
    @PersistenceContext
    private EntityManager entityManager;

    // Method to get coding questions from the specified language table
    @Transactional
    @SuppressWarnings("unchecked")
    public List<CodingQuestion> getCodingQuestionsByLanguage(String languageName, int page, int size) {
        String tableName = languageName.toLowerCase();
        System.out.println("pageaja: " + page + size);

        // Ensure the query uses the CodingQuestion entity
        String queryString = "SELECT cq FROM CodingQuestion cq JOIN cq.language l WHERE LOWER(l.name) = LOWER(:languageName) ORDER BY cq.id";

        System.out.println("Executing SQL: " + queryString);
        try {
            // Use CodingQuestion.class here
            Query query = entityManager.createQuery(queryString, CodingQuestion.class);
            query.setParameter("languageName", languageName);
            query.setFirstResult(page * size);
            query.setMaxResults(size);

            List<CodingQuestion> codingquestions = query.getResultList();
            
            return codingquestions;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving code questions from table: " + tableName, e);
        }
    }
}
