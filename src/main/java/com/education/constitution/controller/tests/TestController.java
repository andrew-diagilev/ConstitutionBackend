package com.education.constitution.controller.tests;

import com.education.constitution.model.DTO.TestResultDTO;
import com.education.constitution.model.tests.Test;
import com.education.constitution.model.tests.TestResult;
import com.education.constitution.service.TestResultMapper;
import com.education.constitution.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    private final TestResultMapper testResultMapper;
    private final TestService testService;

    public TestController(TestResultMapper testResultMapper, TestService testService) {
        this.testResultMapper = testResultMapper;
        this.testService = testService;
    }

    @GetMapping("/")
    public Test getTestById(@RequestParam Long testId) {
       return testService.getTestById(testId);
    }

    @PostMapping("/submit-answer")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Test create(@RequestBody TestResultDTO testResultDTO) {
        TestResult testResult = testResultMapper.dtoToEntity(testResultDTO);
        testService.createTestResult(testResult);
        return testService.getTestById(testResultDTO.getTestId());
    }
}