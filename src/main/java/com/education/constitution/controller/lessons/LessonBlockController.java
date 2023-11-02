package com.education.constitution.controller.lessons;

import com.education.constitution.model.lessons.LessonBlock;
import com.education.constitution.service.LessonBlockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lesson_blocks")
public class LessonBlockController {
    private final LessonBlockService lessonBlockService;

    public LessonBlockController(LessonBlockService lessonBlockService) {
        this.lessonBlockService = lessonBlockService;
    }

    @GetMapping
    public ResponseEntity<List<LessonBlock>> getAllLessonBlocksWithTestResult() {
        return ResponseEntity.ok(lessonBlockService.getAllLessonBlocksWithTestResult());
    }
}

