package com.education.constitution.controller;

import com.education.constitution.model.DTO.TestResultDTO;
import com.education.constitution.model.Test;
import com.education.constitution.model.TestResult;
import com.education.constitution.service.TestResultMapper;
import com.education.constitution.service.TestService;
import com.education.constitution.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tests")
public class TestController {


    @Autowired
    private TestResultMapper testResultMapper;
    @Autowired
    private TestService testService;
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public Test getTestByLessonId(@RequestParam Long lessonId, @RequestParam Long userId) {
        //Тестовая тсрока
        testService.getTestByLessonIdAndUserId(lessonId, userId);
        return testService.getTestByLessonId(lessonId);
    }

    @PostMapping("/submit-answer")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Test create(@RequestBody TestResultDTO testResultDTO) {
        System.out.println(testResultDTO);
        TestResult testResult = testResultMapper.dtoToEntity(testResultDTO);
        testService.createTestResult(testResult);
        return testService.getTestByLessonIdAndUserId(testResultDTO.getLessonId(), testResultDTO.getUserId());
    }


    // Другие методы, если требуется
}