package com.education.constitution.utils.tests;

import com.education.constitution.model.DTO.TestGeneralResultDTO;
import com.education.constitution.model.DTO.TestIndicatorResultDTO;
import com.education.constitution.model.tests.TestResult;
import com.education.constitution.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends BaseRepository<TestResult, Long> {
    List<TestResult> findByTestIdAndUserId(Long testId, Long userId);

    @Query(value = "SELECT " +
            "T1.test_type AS testType, " +
            "T1.total_tests AS totalTests, " +
            "T1.passed_tests AS passedTests, " +
            "T2.correct_answers AS correctAnswers, " +
            "T2.incorrect_answers AS incorrectAnswers, " +
            "T2.total_questions AS totalQuestions, " +
            "T2.answered_questions AS answeredQuestions, " +
            "T2.answered_percentage AS answeredPercentage " +
            "FROM ( " +
            "SELECT " +
            "T.type AS test_type, " +
            "COUNT(T.id) AS total_tests, " +
            "SUM(CASE WHEN PT.passed = 1 THEN 1 ELSE 0 END) AS passed_tests " +
            "FROM test AS T " +
            "LEFT JOIN ( " +
            "SELECT T.id AS test_id, " +
            "CASE WHEN COUNT(Q2.id) = SUM(CASE WHEN R2.user_id = :userId THEN 1 ELSE 0 END) THEN 1 ELSE 0 END AS passed " +
            "FROM test AS T " +
            "LEFT JOIN question AS Q2 ON T.id = Q2.test_id " +
            "LEFT JOIN test_result AS R2 ON Q2.id = R2.question_id " +
            "WHERE R2.user_id = :userId " +
            "GROUP BY T.id " +
            ") AS PT ON T.id = PT.test_id " +
            "WHERE T.type IS NOT NULL " +
            "GROUP BY T.type " +
            ") AS T1 " +
            "JOIN ( " +
            "SELECT " +
            "T.type AS test_type, " +
            "SUM(CASE WHEN A.correct = 1 THEN 1 ELSE 0 END) AS correct_answers, " +
            "SUM(CASE WHEN A.correct = 0 THEN 1 ELSE 0 END) AS incorrect_answers, " +
            "COUNT(Q.id) AS total_questions, " +
            "COUNT(DISTINCT R.question_id) AS answered_questions, " +
            "(COUNT(DISTINCT R.question_id) / COUNT(Q.id)) * 100 AS answered_percentage " +
            "FROM test AS T " +
            "LEFT JOIN question AS Q ON T.id = Q.test_id " +
            "LEFT JOIN test_result AS R ON Q.id = R.question_id AND R.user_id = :userId " +
            "LEFT JOIN answer AS A ON R.answer_id = A.id " +
            "WHERE T.type IS NOT NULL " +
            "GROUP BY T.type " +
            ") AS T2 " +
            "ON T1.test_type = T2.test_type", nativeQuery = true)
    List<TestGeneralResultDTO> getTestResultsForUser(@Param("userId") Long userId);

    @Query(value =
            "SELECT " +
                    "    t.id AS id, " +
                    "    t.type AS testType, " +
                    "    COUNT(DISTINCT q.id) AS questions, " +
                    "    COUNT(DISTINCT tr.id) AS userAnswers, " +
                    "    COUNT(DISTINCT CASE WHEN a.correct = 1 THEN tr.id END) AS correctAnswers " +
                    "FROM test t " +
                    "LEFT JOIN question q ON t.id = q.test_id " +
                    "LEFT JOIN test_result tr ON t.id = tr.test_id AND tr.user_id = :userId " +
                    "LEFT JOIN answer a ON tr.answer_id = a.id " +
                    "WHERE t.type = :testType OR tr.id IS NULL " +
                    "GROUP BY t.id, t.type " +
                    "HAVING t.type = :testType", nativeQuery = true)
    List<TestIndicatorResultDTO> getTestResultsForUserAndType(@Param("userId") Long userId, @Param("testType") String testType);

    void deleteByTestIdAndUserId(Long testId, Long userId);

}
