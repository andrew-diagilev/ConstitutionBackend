package com.education.constitution.model.tests;

import com.education.constitution.model.lessons.LessonBlock;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class FinalTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_block_id")
    private LessonBlock lessonBlock;

    @OneToMany(mappedBy = "finalTest", cascade = CascadeType.ALL)
    private List<FinalQuestion> questions;


}