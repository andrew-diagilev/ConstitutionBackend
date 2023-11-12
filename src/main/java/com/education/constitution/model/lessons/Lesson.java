package com.education.constitution.model.lessons;

import com.education.constitution.model.AbstractLessonItem;
import com.education.constitution.model.tests.Test;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Lesson extends AbstractLessonItem {

    private String name;
    private String title;
    private String description;
    private String videoUrl;

    @ManyToOne // Урок принадлежит к одному блоку уроков
    @JoinColumn(name = "lesson_block_id") // Связь осуществляется через поле lessonBlock_id
    @JsonIgnore
    private LessonBlock lessonBlock;

    @OneToOne(mappedBy = "lesson")
    @JsonIgnore
    private Test test;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public Test getTest() {
        return test;
    }
}