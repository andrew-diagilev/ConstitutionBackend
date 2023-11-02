/*
package com.education.constitution.controller.tests;

import com.education.constitution.model.DTO.FinalTestResultDTO;
import com.education.constitution.model.DTO.TestResultDTO;
import com.education.constitution.model.tests.FinalTest;
import com.education.constitution.model.tests.FinalTestResult;

import com.education.constitution.service.FinalTestResultMapper;
import com.education.constitution.service.FinalTestService;
import com.education.constitution.service.TestResultMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/final_tests")
public class FinalTestController {

    private final FinalTestResultMapper testResultMapper;
    private final FinalTestService finalTestService;

    public FinalTestController(FinalTestResultMapper testResultMapper, FinalTestService finalTestService) {
        this.testResultMapper = testResultMapper;
        this.finalTestService = finalTestService;
    }


    @GetMapping("/")
    public FinalTest getFinalTestByLessonIdAndUserId(@RequestParam Long lessonBlockId, @RequestParam Long userId) {
        FinalTest finalTest = finalTestService.getFinalTestByLessonBlockIdAndUserId(lessonBlockId, userId);
        return finalTest;
    }

    @PostMapping("/submit-answer")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public FinalTest create(@RequestBody FinalTestResultDTO testResultDTO) {

        FinalTestResult testResult = testResultMapper.dtoToEntity(testResultDTO);
        finalTestService.createFinalTestResult(testResult);
        return finalTestService.getFinalTestByLessonBlockIdAndUserId(testResultDTO.getLessonBlockId(), testResultDTO.getUserId());
    }
}*/
