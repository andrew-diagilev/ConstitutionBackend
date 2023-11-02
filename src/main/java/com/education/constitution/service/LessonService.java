package com.education.constitution.service;

import com.education.constitution.model.DTO.TestIndicatorResultDTO;
import com.education.constitution.model.lessons.Lesson;
import com.education.constitution.repository.lessons.LessonRepository;
import com.education.constitution.repository.tests.TestResultRepository;
import com.education.constitution.utils.UserDetailsProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService extends AbstractService<Lesson, Long, LessonRepository> {

    private TestResultRepository testResultRepository;
    private UserDetailsProvider userDetailsProvider;

    private TestResultMappingService testResultMappingService;

    public LessonService(LessonRepository repository, TestResultRepository testResultRepository, UserDetailsProvider userDetailsProvider, TestResultMappingService testResultMappingService) {
        super(repository);
        this.testResultRepository = testResultRepository;
        this.userDetailsProvider = userDetailsProvider;
        this.testResultMappingService = testResultMappingService;
    }

    public List<Lesson> getAllLessonsWithTestResult(){
        Long userId = userDetailsProvider.getCurrentUserId();
        List<Lesson> allLessons = repository.findAll();
        List<TestIndicatorResultDTO> testResults = testResultRepository.getTestResultsForUserAndType(userId, "lesson");

        return testResultMappingService.mapItemsWithTestResult(allLessons, testResults);
      /*  // Создаем мапу для быстрого доступа к результатам тестов по их ID
        Map<Long, TestIndicatorResultDTO> testResultMap = testResults.stream()
                .collect(Collectors.toMap(TestIndicatorResultDTO::getId, Function.identity()));

        // Обновляем уроки с результатами тестов
        List<Lesson> lessonsWithTestResults = allLessons.stream()
                .filter(lesson -> testResultMap.containsKey(lesson.getId()))
                .map(lesson -> {
                    TestIndicatorResultDTO testResult = testResultMap.get(lesson.getId());
                    lesson.setTestResult(testResult);
                    return lesson;
                })
                .collect(Collectors.toList());

        return lessonsWithTestResults;*/
    }

  /*  public List<Lesson> getAllLessons() {
        return repository.findAll();
    }*/

    /*public Lesson getLessonById(Long lessonId) {
        return repository.findById(lessonId)
                .orElseThrow(() -> new NotFoundException("Lesson not found with id: " + lessonId));
    }*/

    // Другие методы сервиса (если требуется)
}
