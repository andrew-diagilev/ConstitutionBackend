package com.education.constitution.service;

import com.education.constitution.exception.NotFoundException;
import com.education.constitution.model.tests.Answer;
import com.education.constitution.model.tests.Test;
import com.education.constitution.model.tests.TestResult;
import com.education.constitution.utils.UserDetailsProvider;
import com.education.constitution.utils.tests.TestRepository;
import com.education.constitution.utils.tests.TestResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TestService extends AbstractService<Test, Long, TestRepository> {

    private final TestResultRepository testResultRepository;
    private final UserDetailsProvider userDetailsProvider;

    public TestService(TestRepository testRepository, TestResultRepository testResultRepository, UserDetailsProvider userDetailsProvider) {
        super(testRepository);
        this.testResultRepository = testResultRepository;
        this.userDetailsProvider = userDetailsProvider;
    }

    public Test createTestResult(TestResult testResult) {
        testResultRepository.save(testResult);
        return repository.findById(Long.valueOf(1)).get();
    }

    public Test getTestById(Long testId) {
        Long userId = userDetailsProvider.getCurrentUserId();
        Test test = repository.findById(testId).orElseThrow(() -> new NotFoundException("Test not found with Id: " + testId));
        List<TestResult> testResultList = testResultRepository.findByTestIdAndUserId(testId, userId);
        updateAnsweredField(testResultList, test);
        return test;
    }


    private void updateAnsweredField(List<TestResult> testResults, Test test) {
        List<Answer> answers = test.getQuestions()
                .stream()
                .flatMap(question -> question.getAnswers().stream())
                .collect(Collectors.toList());

        testResults.stream()
                .map(TestResult::getAnswer)
                .filter(answer -> answers.stream()
                        .anyMatch(a -> a.getId().equals(answer.getId())))
                .forEach(answer -> answers.stream()
                        .filter(a -> a.getId().equals(answer.getId()))
                        .findFirst()
                        .ifPresent(a -> a.setAnswered(true)));
    }
}