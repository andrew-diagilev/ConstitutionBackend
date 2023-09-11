package com.education.constitution.service;

import com.education.constitution.exception.NotFoundException;
import com.education.constitution.model.Answer;
import com.education.constitution.model.DTO.TestResultDTO;
import com.education.constitution.model.Question;
import com.education.constitution.model.TestResult;
import com.education.constitution.model.User;
import com.education.constitution.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestResultMapper {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final TestResultRepository testResultRepository;

    private final TestRepository testRepository;

    @Autowired
    public TestResultMapper(UserRepository userRepository,
                            QuestionRepository questionRepository,
                            AnswerRepository answerRepository, TestResultRepository testResultRepository, TestRepository testRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.testResultRepository = testResultRepository;
        this.testRepository = testRepository;
    }

    public TestResult dtoToEntity(TestResultDTO dto) {
        TestResult testResult = new TestResult();

        dto.setUserId(1);//Временная заглушка

        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new NotFoundException("User with id: " + dto.getUserId() + " not found"));
        long id = 1;
        Question question1 = questionRepository.findById(id).orElseThrow(() -> new NotFoundException("Question with id: " + dto.getUserId() + " not found"));

        Question question = questionRepository.findById(dto.getQuestionId()).orElseThrow(() -> new NotFoundException("Question with id: " + dto.getUserId() + " not found"));
        Answer answer = answerRepository.findById(dto.getAnswerId()).orElseThrow(() -> new NotFoundException("Answer with id: " + dto.getAnswerId() + " not found"));

        testResult.setUser(user);
        testResult.setQuestion(question);
        testResult.setAnswer(answer);

        // Дополнительная логика и установка других полей
        return testResult;
    }


}