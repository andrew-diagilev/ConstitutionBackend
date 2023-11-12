package com.education.constitution.controller.lessons;

import com.education.constitution.exception.NotFoundException;
import com.education.constitution.model.lessons.Summary;
import com.education.constitution.utils.tests.TestResultRepository;
import com.education.constitution.service.SummaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/summaries")
public class SummaryController {
    private final SummaryService summaryService;
    private final TestResultRepository testResultRepository;

    public SummaryController(SummaryService summaryService, TestResultRepository testResultRepository) {
        this.summaryService = summaryService;
        this.testResultRepository = testResultRepository;
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<?> getSummariesByLessonId(@PathVariable Long lessonId) {
        try{
            return ResponseEntity.ok(summaryService.getSummaryByLessonId(lessonId));
        }
        catch (NotFoundException e){
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("all")
    public List<Summary> getAllSummaries(){
       return summaryService.getAll();
    }
}