package com.prepquest.prepquest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "language", indexes = {
    @Index(name = "idx_language_name", columnList = "name")
})
public class Language {

    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    @JsonProperty("name")
    private String name;

    @Lob
    @JsonProperty("icon")
    private String icon;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

 
    
    
}