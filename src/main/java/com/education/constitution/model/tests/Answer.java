package com.education.constitution.model.tests;

import com.education.constitution.model.AbstractEntity;
import jakarta.persistence.*;

@Entity
public class Answer extends AbstractEntity {

    @Column(columnDefinition = "TEXT")
    private String text;
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Transient
    private boolean answered;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
}
