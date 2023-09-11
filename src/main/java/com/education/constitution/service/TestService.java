package com.education.constitution.service;

import com.education.constitution.exception.NotFoundException;
import com.education.constitution.model.Answer;
import com.education.constitution.model.Question;
import com.education.constitution.model.Test;
import com.education.constitution.model.TestResult;
import com.education.constitution.repository.TestRepository;
import com.education.constitution.repository.TestResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TestService extends AbstractService<Test, Long, TestRepository> {

    private final TestResultRepository testResultRepository;

    public TestService(TestRepository testRepository, TestResultRepository testResultRepository) {
        super(testRepository);
        this.testResultRepository = testResultRepository;
    }

    public Test createTestResult(TestResult testResult) {
        testResultRepository.save(testResult);
        return repository.findById(Long.valueOf(1)).get();
    }

    public Test getTestByLessonId(Long lessonId) {
        return repository.findByLessonId(lessonId).orElseThrow(() -> new NotFoundException("Test not found with lessonId: " + lessonId));
    }

    public Test getTestByLessonIdAndUserId(Long lessonId, Long userId) {
        Test test = repository.findByLessonId(lessonId).orElseThrow(() -> new NotFoundException("Test not found with lessonId: " + lessonId));
        List<TestResult> testResultList = testResultRepository.findByTestIdAndUserId(test.getId(), userId);
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

// Другие методы сервиса (если требуется)

}