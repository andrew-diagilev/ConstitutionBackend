package com.education.constitution.repository.tests;

import com.education.constitution.model.tests.FinalTestResult;
import com.education.constitution.model.tests.TestResult;
import com.education.constitution.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinalTestResultRepository extends BaseRepository<FinalTestResult, Long> {
    List<FinalTestResult> findByTestIdAndUserId(Long finalTestId, Long userId);

}
