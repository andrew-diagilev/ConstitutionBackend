package com.education.constitution.repository.tests;

import com.education.constitution.model.tests.TestResult;
import com.education.constitution.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends BaseRepository<TestResult, Long> {
    List<TestResult> findByTestIdAndUserId(Long testId, Long userId);

}
