package com.education.constitution.repository;

import com.education.constitution.model.Test;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends BaseRepository<Test, Long> {
    Optional<Test> findByLessonId(Long lessonId);
}