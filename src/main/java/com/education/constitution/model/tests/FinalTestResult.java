package com.education.constitution.model.tests;

import com.education.constitution.model.users.User;
import jakarta.persistence.*;

@Entity
public class FinalTestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private FinalQuestion question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private FinalAnswer answer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private FinalTest test;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FinalQuestion getQuestion() {
        return question;
    }

    public void setQuestion(FinalQuestion question) {
        this.question = question;
    }

    public FinalAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(FinalAnswer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FinalTest getTest() {
        return test;
    }

    public void setTest(FinalTest test) {
        this.test = test;
    }
}
