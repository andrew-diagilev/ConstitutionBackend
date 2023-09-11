package com.education.constitution.repository;

import com.education.constitution.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends BaseRepository<TestResult, Long> {
    List<TestResult> findByTestIdAndUserId(Long testId, Long userId);

}
