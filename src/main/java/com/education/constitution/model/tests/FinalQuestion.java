package com.education.constitution.model.tests;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class FinalQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @OneToMany(mappedBy = "finalQuestion", cascade = CascadeType.ALL)
    private List<FinalAnswer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<FinalAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<FinalAnswer> answers) {
        this.answers = answers;
    }
}
