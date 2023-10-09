package com.education.constitution.service;

import com.education.constitution.exception.NotFoundException;
import com.education.constitution.model.lessons.Summary;
import com.education.constitution.repository.lessons.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryService extends AbstractService<Summary, Long, SummaryRepository> {
    @Autowired
    private SummaryRepository summaryRepository;

    public SummaryService(SummaryRepository summaryRepository) {
        super(summaryRepository);
    }

    public Summary getSummaryByLessonId(Long lessonId) {
        return summaryRepository.findByLessonId(lessonId)
                .orElseThrow(() -> new NotFoundException("Summary not found for lesson with id: " + lessonId));
    }
}
