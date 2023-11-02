/*
package com.education.constitution.model.tests;

import com.education.constitution.model.lessons.LessonBlock;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class FinalTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "lesson_block_id")
    @JsonIgnore
    private LessonBlock lessonBlock;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<FinalQuestion> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LessonBlock getLessonBlock() {
        return lessonBlock;
    }

    public void setLessonBlock(LessonBlock lessonBlock) {
        this.lessonBlock = lessonBlock;
    }

    public List<FinalQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<FinalQuestion> questions) {
        this.questions = questions;
    }
}*/
