package com.education.constitution.repository;

import com.education.constitution.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SummaryRepository extends BaseRepository<Summary, Long> {
    Optional<Summary> findByLessonId(Long lessonId);
}