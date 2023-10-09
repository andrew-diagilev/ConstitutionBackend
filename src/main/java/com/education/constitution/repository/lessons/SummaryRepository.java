package com.education.constitution.repository.lessons;

import com.education.constitution.model.lessons.Summary;
import com.education.constitution.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SummaryRepository extends BaseRepository<Summary, Long> {
    Optional<Summary> findByLessonId(Long lessonId);
}