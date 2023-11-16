package com.education.constitution.service;

import com.education.constitution.exception.NotFoundException;
import com.education.constitution.model.DTO.TestResultDTO;
import com.education.constitution.model.tests.Answer;
import com.education.constitution.model.tests.Question;
import com.education.constitution.model.tests.Test;
import com.education.constitution.model.tests.TestResult;
import com.education.constitution.model.users.User;
import com.education.constitution.utils.UserDetailsProvider;
import com.education.constitution.utils.tests.AnswerRepository;
import com.education.constitution.utils.tests.QuestionRepository;
import com.education.constitution.utils.tests.TestRepository;
import com.education.constitution.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestResultMapper {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final TestRepository testRepository;
    private final UserDetailsProvider userDetailsProvider;

    @Autowired
    public TestResultMapper(UserRepository userRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, TestRepository testRepository, UserDetailsProvider userDetailsProvider) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.testRepository = testRepository;
        this.userDetailsProvider = userDetailsProvider;
    }

    public TestResult dtoToEntity(TestResultDTO dto) {
        TestResult testResult = new TestResult();
        Long userId = userDetailsProvider.getCurrentUserId();
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("Користувача з id: " + dto.getUserId() + " не знайдено"));
        Question question = questionRepository.findById(dto.getQuestionId()).orElseThrow(() -> new NotFoundException("Питання з id: " + dto.getQuestionId() + " не знайдено"));
        Answer answer = answerRepository.findById(dto.getAnswerId()).orElseThrow(() -> new NotFoundException("Відповіді з id: " + dto.getAnswerId() + " не знайдено"));
        Test test = testRepository.findById(dto.getTestId()).orElseThrow(() -> new NotFoundException("Тесту з id: " + dto.getAnswerId() + " не знайдено"));
        testResult.setTest(test);
        testResult.setUser(user);
        testResult.setQuestion(question);
        testResult.setAnswer(answer);
        return testResult;
    }
}
