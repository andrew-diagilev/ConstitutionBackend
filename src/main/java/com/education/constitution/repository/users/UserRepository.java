package com.education.constitution.repository.users;

import com.education.constitution.model.users.User;
import com.education.constitution.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    /*User findByEmail(String email);*/
    public boolean existsByUserName(String username);
    User findByUserName(String userName);
    Optional<User> findByIdAndAccessCodeCodeAndEmail(Long id, String accessCode, String email);
    Optional<User> findByAccessCodeCode(String accessCode);

}