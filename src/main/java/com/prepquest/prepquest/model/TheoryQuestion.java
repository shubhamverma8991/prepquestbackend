package com.prepquest.prepquest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "theoryquestion", indexes = {
    @Index(name = "idx_theoryquestion_language_id", columnList = "language_id"),
    @Index(name = "idx_theoryquestion_language_id_id", columnList = "language_id, id")
})
public class TheoryQuestion {

    @Id
    private Long id;
    
    @Column(columnDefinition = "TEXT")
    private String question;
    @Column(name = "askedincompany")
    private String askedincompany;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    @JsonIgnore  // Prevent serialization of this field
    private Language language;

    // @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAskedInCompany() {
        return askedincompany;
    }

    public void setAskedInCompany(String askedInCompany) {
        this.askedincompany = askedInCompany;
    }

    public Language getLanguage() {
        return language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}