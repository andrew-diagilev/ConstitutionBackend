package com.education.constitution.service;

import com.education.constitution.exception.NotFoundException;
import com.education.constitution.model.Lesson;
import com.education.constitution.repository.LessonRepository;
import com.education.constitution.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
