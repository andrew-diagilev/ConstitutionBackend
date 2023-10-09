package com.education.constitution.repository.tests;

import com.education.constitution.model.tests.Question;
import com.education.constitution.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends BaseRepository<Question, Long> {

}