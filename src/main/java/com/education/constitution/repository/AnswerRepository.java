package com.education.constitution.repository;

import com.education.constitution.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends BaseRepository<Answer, Long> {

}