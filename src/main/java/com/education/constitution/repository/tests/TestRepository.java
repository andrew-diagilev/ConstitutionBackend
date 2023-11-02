package com.education.constitution.repository.tests;

import com.education.constitution.model.tests.Test;
import com.education.constitution.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends BaseRepository<Test, Long> {
    Optional<Test> findByLessonId(Long lessonId);
    Optional<Test> findByLessonBlockId(Long lessonBlockId);
}