package com.education.constitution.controller.tests;

import com.education.constitution.model.DTO.TestGeneralResultDTO;
import com.education.constitution.service.TestResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/tests/result")
public class TestResultController {

    private TestResultService testResultService;

    public TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @GetMapping("/general")
    public Map<String, TestGeneralResultDTO> getTestResultByUserId(@RequestParam Long userId) {
        return testResultService.getResultForUserId(userId);
    }

    @DeleteMapping ("/{testId}")
    public ResponseEntity deleteTestResult(@PathVariable  Long testId) {
        testResultService.deleteByTestId(testId);
        return ResponseEntity.ok().build();
    }
}