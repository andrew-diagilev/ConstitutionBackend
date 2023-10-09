package com.education.constitution.repository.users;

import com.education.constitution.model.users.AccessCode;
import com.education.constitution.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessCodeRepository extends BaseRepository<AccessCode, Long> {
    Optional<AccessCode> findByCode(String code);
    boolean existsByCode(String code);
}
