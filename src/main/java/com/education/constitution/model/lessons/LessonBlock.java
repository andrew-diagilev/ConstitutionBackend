package com.education.constitution.model.lessons;

import com.education.constitution.model.tests.FinalTest;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class LessonBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String text;

    @OneToMany(mappedBy = "lessonBlock", cascade = CascadeType.ALL)
    private List<FinalTest> finalTests;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<FinalTest> getFinalTests() {
        return finalTests;
    }

    public void setFinalTests(List<FinalTest> finalTests) {
        this.finalTests = finalTests;
    }
}