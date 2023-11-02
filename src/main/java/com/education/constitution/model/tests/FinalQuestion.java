/*
package com.education.constitution.model.tests;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class FinalQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<FinalAnswer> answers;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private FinalTest test;

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
*/
