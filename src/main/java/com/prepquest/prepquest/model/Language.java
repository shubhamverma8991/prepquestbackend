package com.prepquest.prepquest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {

    @Id
    private Long id;
    @Column(unique = true, nullable = false)
    @JsonProperty("languagename")
    private String languagename;
    @Lob
    @JsonProperty("languageicon")
    private String languageicon;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languagename;
    }

    public void setLanguageName(String languagename) {
        this.languagename = languagename;
    }

    public String getLanguageIcon() {
        return languageicon;
    }

    public void setLanguageIcon(String languageicon) {
        this.languageicon = languageicon;
    }


   
}