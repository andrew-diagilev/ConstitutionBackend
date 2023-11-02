package com.education.constitution.controller.tests;

import com.education.constitution.model.DTO.TestGeneralResultDTO;
import com.education.constitution.service.TestResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}