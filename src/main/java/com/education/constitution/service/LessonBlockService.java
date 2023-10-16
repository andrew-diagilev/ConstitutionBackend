package com.education.constitution.service;

import com.education.constitution.model.lessons.LessonBlock;
import com.education.constitution.repository.lessons.LessonBlockRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonBlockService extends AbstractService<LessonBlock, Long, LessonBlockRepository> {
    public LessonBlockService(LessonBlockRepository repository) {
        super(repository);
    }
}