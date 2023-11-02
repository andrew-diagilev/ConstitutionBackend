package com.education.constitution.model.lessons;

import com.education.constitution.model.AbstractLessonItem;
import com.education.constitution.model.tests.Test;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class LessonBlock extends AbstractLessonItem {

    private String name;
    private String text;

    @OneToOne(mappedBy = "lessonBlock")
    @JsonIgnore
    private Test test;

    @OneToMany(mappedBy = "lessonBlock"/*, fetch=FetchType.LAZY*/) // Один блок уроков содержит множество уроков
    private List<Lesson> lessons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public Test getTest() {
        return test;
    }
}