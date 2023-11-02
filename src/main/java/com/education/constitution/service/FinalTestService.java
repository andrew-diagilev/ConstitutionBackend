/*
package com.education.constitution.service;

import com.education.constitution.exception.NotFoundException;
import com.education.constitution.model.tests.*;
import com.education.constitution.repository.tests.FinalTestRepository;
import com.education.constitution.repository.tests.FinalTestResultRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinalTestService extends AbstractService<FinalTest, Long, FinalTestRepository> {

    private final FinalTestResultRepository finalTestResultRepository;

    public FinalTestService(FinalTestRepository repository, FinalTestResultRepository finalTestResultRepository) {
        super(repository);
        this.finalTestResultRepository = finalTestResultRepository;
    }

    public FinalTest createFinalTestResult(FinalTestResult testResult) {
        finalTestResultRepository.save(testResult);
        return repository.findById(Long.valueOf(1)).get();
    }

    public FinalTest getFinalTestByLessonBlockId(Long lessonId) {
        return repository.findByLessonBlockId(lessonId).orElseThrow(() -> new NotFoundException("Test not found with lessonId: " + lessonId));
    }

    public FinalTest getFinalTestByLessonBlockIdAndUserId(Long lessonId, Long userId) {
        FinalTest test = repository.findByLessonBlockId(lessonId).orElseThrow(() -> new NotFoundException("Test not found with lessonId: " + lessonId));
        List<FinalTestResult> testResultList = finalTestResultRepository.findByTestIdAndUserId(test.getId(), userId);
        updateAnsweredField(testResultList, test);
        return test;
    }

    private void updateAnsweredField(List<FinalTestResult> testResults, FinalTest test) {
        List<FinalAnswer> answers = test.getQuestions()
                .stream()
                .flatMap(question -> question.getAnswers().stream())
                .collect(Collectors.toList());

        testResults.stream()
                .map(FinalTestResult::getAnswer)
                .filter(answer -> answers.stream()
                        .anyMatch(a -> a.getId().equals(answer.getId())))
                .forEach(answer -> answers.stream()
                        .filter(a -> a.getId().equals(answer.getId()))
                        .findFirst()
                        .ifPresent(a -> a.setAnswered(true)));
    }
}
*/
