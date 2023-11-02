package com.education.constitution.service;

import com.education.constitution.model.DTO.TestGeneralResultDTO;
import com.education.constitution.model.tests.TestResult;
import com.education.constitution.repository.tests.TestResultRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TestResultService extends AbstractService<TestResult, Long, TestResultRepository> {

    public TestResultService(TestResultRepository repository) {
        super(repository);
    }


    public Map<String, TestGeneralResultDTO> getResultForUserId(Long userId) {

        List<TestGeneralResultDTO> testGeneralResultDTOList = repository.getTestResultsForUser(userId);
        Map<String, TestGeneralResultDTO> resultMap = testGeneralResultDTOList.stream()
                .collect(Collectors.toMap(TestGeneralResultDTO::getTestType, Function.identity()));
        return resultMap;
    }
}
