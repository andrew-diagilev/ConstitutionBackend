/*
package com.education.constitution.service;

import com.education.constitution.exception.NotFoundException;
import com.education.constitution.model.DTO.FinalTestResultDTO;
import com.education.constitution.model.tests.*;
import com.education.constitution.model.users.User;
import com.education.constitution.repository.tests.*;
import com.education.constitution.repository.users.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FinalTestResultMapper {

    private final UserRepository userRepository;
    private final FinalQuestionRepository questionRepository;
    private final FinalAnswerRepository answerRepository;
    private final FinalTestRepository testRepository;

        public FinalTestResultMapper(UserRepository userRepository, FinalQuestionRepository questionRepository, FinalAnswerRepository answerRepository, FinalTestRepository testRepository) {
            this.userRepository = userRepository;
            this.questionRepository = questionRepository;
            this.answerRepository = answerRepository;
            this.testRepository = testRepository;
        }

        public FinalTestResult dtoToEntity(FinalTestResultDTO dto) {
        FinalTestResult testResult = new FinalTestResult();
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new NotFoundException("User with id: " + dto.getUserId() + " not found"));
        FinalQuestion question = questionRepository.findById(dto.getQuestionId()).orElseThrow(() -> new NotFoundException("Question with id: " + dto.getQuestionId() + " not found"));
        FinalAnswer answer = answerRepository.findById(dto.getAnswerId()).orElseThrow(() -> new NotFoundException("Answer with id: " + dto.getAnswerId() + " not found"));
        FinalTest test = testRepository.findById(dto.getTestId()).orElseThrow(() -> new NotFoundException("Test with id: " + dto.getAnswerId() + " not found"));

        testResult.setTest(test);
        testResult.setUser(user);
        testResult.setQuestion(question);
        testResult.setAnswer(answer);

        // Дополнительная логика и установка других полей
        return testResult;
    }
}
*/
