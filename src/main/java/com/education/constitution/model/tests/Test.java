package com.education.constitution.model.tests;

import com.education.constitution.model.AbstractEntity;
import com.education.constitution.model.lessons.Lesson;

import com.education.constitution.model.lessons.LessonBlock;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Test extends AbstractEntity {

    private String type;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    @JsonIgnore
    private Lesson lesson;

    @OneToOne
    @JoinColumn(name = "lesson_block_id")
    @JsonIgnore
    private LessonBlock lessonBlock;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Question> questions;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public LessonBlock getLessonBlock() {
        return lessonBlock;
    }

    public void setLessonBlock(LessonBlock lessonBlock) {
        this.lessonBlock = lessonBlock;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}