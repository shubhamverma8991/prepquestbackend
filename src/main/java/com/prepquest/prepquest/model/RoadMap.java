package com.prepquest.prepquest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "roadmap")
public class RoadMap {

    @Id
    private Long id;
    @Column(unique = true, nullable = false)
    @JsonProperty("coursename")
    private String coursename;
    @Lob
    @JsonProperty("courseicon")
    private String courseicon;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcoursename() {
        return coursename;
    }

    public void setcoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getcourseicon() {
        return courseicon;
    }

    public void setcourseicon(String courseicon) {
        this.courseicon = courseicon;
    } 
}