package com.education.constitution.repository.lessons;

import com.education.constitution.model.lessons.Lesson;
import com.education.constitution.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends BaseRepository<Lesson, Long> {

}