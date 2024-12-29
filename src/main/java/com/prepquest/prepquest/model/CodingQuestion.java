package com.prepquest.prepquest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "codingquestion")
public class CodingQuestion {
    
    @Id
    private Long id;
    
    @Column(columnDefinition = "TEXT")
    private String question;
    @Column(name = "askedincompany")
    private String askedincompany;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @Lob
    @Column(name="imageexplaination")
    private String imageexplaination;


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

    public String getImageexplaination() {
        return imageexplaination;
    }

    public void setImageexplaination(String imageexplaination) {
        this.imageexplaination = imageexplaination;
    }
    
}
