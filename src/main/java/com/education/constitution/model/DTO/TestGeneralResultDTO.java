package com.education.constitution.model.DTO;

public interface TestGeneralResultDTO {


    String getTestType();
    Long getTotalTests();
    Long getPassedTests();
    Long getCorrectAnswers();
    Long getIncorrectAnswers();
    Long getTotalQuestions();
    Long getAnsweredQuestions();
    Double getAnsweredPercentage();

}

