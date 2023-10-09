package com.education.constitution.repository.tests;

import com.education.constitution.model.tests.Answer;
import com.education.constitution.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends BaseRepository<Answer, Long> {

}