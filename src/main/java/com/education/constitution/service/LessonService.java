package com.education.constitution.service;

import com.education.constitution.model.lessons.Lesson;
import com.education.constitution.repository.lessons.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonService extends AbstractService<Lesson, Long, LessonRepository> {


    public LessonService(LessonRepository repository) {
        super(repository);
    }

  /*  public List<Lesson> getAllLessons() {
        return repository.findAll();
    }*/

    /*public Lesson getLessonById(Long lessonId) {
        return repository.findById(lessonId)
                .orElseThrow(() -> new NotFoundException("Lesson not found with id: " + lessonId));
    }*/

    // Другие методы сервиса (если требуется)
}
