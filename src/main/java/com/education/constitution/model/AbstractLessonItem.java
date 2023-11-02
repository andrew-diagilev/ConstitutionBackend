package com.education.constitution.model;

import com.education.constitution.model.DTO.TestIndicatorResultDTO;
import com.education.constitution.model.tests.Test;
import jakarta.persistence.Transient;

public abstract class AbstractLessonItem extends AbstractEntity{
    @Transient
    private TestIndicatorResultDTO testResult;

    public TestIndicatorResultDTO getTestResult() {
        return testResult;
    }

    public void setTestResult(TestIndicatorResultDTO testResult) {
        this.testResult = testResult;
    }

    public abstract Test getTest();
}
