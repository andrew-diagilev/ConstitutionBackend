package com.education.constitution.service;

import com.education.constitution.model.AbstractLessonItem;
import com.education.constitution.model.DTO.TestIndicatorResultDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TestResultMappingService {

    public <T extends AbstractLessonItem> List<T> mapItemsWithTestResult(List<T> allItems, List<TestIndicatorResultDTO> testResults) {

        // Создаем мапу для быстрого доступа к результатам тестов по их ID
        Map<Long, TestIndicatorResultDTO> testResultMap = testResults.stream()
                .collect(Collectors.toMap(TestIndicatorResultDTO::getId, Function.identity()));

        // Обновляем уроки с результатами тестов
        List<T> itemsWithTestResults = allItems.stream()
                .filter(item -> testResultMap.containsKey(item.getTest().getId()))
                .map(item -> {
                    TestIndicatorResultDTO testResult = testResultMap.get(item.getTest().getId());
                    item.setTestResult(testResult);
                    return item;
                })
                .collect(Collectors.toList());
        return itemsWithTestResults;
    }
}