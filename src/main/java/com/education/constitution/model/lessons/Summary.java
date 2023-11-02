package com.education.constitution.model.lessons;

import com.education.constitution.model.AbstractEntity;
import jakarta.persistence.*;

@Entity
public class Summary extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    @Column(columnDefinition = "TEXT")
    private String text;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}