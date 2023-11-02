package com.education.constitution.controller.lessons;

import com.education.constitution.model.lessons.Lesson;
import com.education.constitution.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService lessonService;
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public ResponseEntity<List<Lesson>> getAllLessonsWithTestResult() {
        return ResponseEntity.ok(lessonService.getAllLessonsWithTestResult());
    }/*ResponseEntity.status(HttpStatus.NOT_FOUND).body("dsfsdfsdfsdfdsf");*/
}
