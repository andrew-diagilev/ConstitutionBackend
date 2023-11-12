package com.education.constitution.service;

import com.education.constitution.model.DTO.TestGeneralResultDTO;
import com.education.constitution.model.tests.TestResult;
import com.education.constitution.utils.UserDetailsProvider;
import com.education.constitution.utils.tests.TestResultRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TestResultService extends AbstractService<TestResult, Long, TestResultRepository> {
    private UserDetailsProvider userDetailsProvider;

    public TestResultService(TestResultRepository repository, UserDetailsProvider userDetailsProvider) {
        super(repository);
        this.userDetailsProvider = userDetailsProvider;
    }


    public Map<String, TestGeneralResultDTO> getResultForUserId(Long userId) {

        List<TestGeneralResultDTO> testGeneralResultDTOList = repository.getTestResultsForUser(userId);
        Map<String, TestGeneralResultDTO> resultMap = testGeneralResultDTOList.stream()
                .collect(Collectors.toMap(TestGeneralResultDTO::getTestType, Function.identity()));
        return resultMap;
    }

    @Transactional
    public void deleteByTestId(Long testId){
        Long userId = userDetailsProvider.getCurrentUserId();
        repository.deleteByTestIdAndUserId(testId, userId);
    }
}
