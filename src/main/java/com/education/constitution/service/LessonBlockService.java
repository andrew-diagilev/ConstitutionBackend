package com.education.constitution.service;

import com.education.constitution.model.DTO.TestIndicatorResultDTO;
import com.education.constitution.model.lessons.Lesson;
import com.education.constitution.model.lessons.LessonBlock;
import com.education.constitution.repository.lessons.LessonBlockRepository;
import com.education.constitution.repository.tests.TestResultRepository;
import com.education.constitution.utils.UserDetailsProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonBlockService extends AbstractService<LessonBlock, Long, LessonBlockRepository> {

    private UserDetailsProvider userDetailsProvider;
    private TestResultRepository testResultRepository;
    private TestResultMappingService testResultMappingService;

    public LessonBlockService(LessonBlockRepository repository, UserDetailsProvider userDetailsProvider, TestResultRepository testResultRepository, TestResultMappingService testResultMappingService) {
        super(repository);
        this.userDetailsProvider = userDetailsProvider;
        this.testResultRepository = testResultRepository;
        this.testResultMappingService = testResultMappingService;
    }

    public List<LessonBlock> getAllLessonBlocksWithTestResult() {
        Long userId = userDetailsProvider.getCurrentUserId();
        List<LessonBlock> allLessonBlocks = repository.findAll();
        List<TestIndicatorResultDTO> testResults = testResultRepository.getTestResultsForUserAndType(userId, "block");

        return testResultMappingService.mapItemsWithTestResult(allLessonBlocks, testResults);

    }
}