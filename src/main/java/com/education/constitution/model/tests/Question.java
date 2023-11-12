package com.education.constitution.model.tests;

import com.education.constitution.model.AbstractEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question extends AbstractEntity {
    @Column(columnDefinition = "TEXT")
    private String text;

    // Отношение с вариантами ответов
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}

