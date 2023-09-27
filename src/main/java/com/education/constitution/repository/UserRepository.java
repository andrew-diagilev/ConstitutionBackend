package com.education.constitution.repository;

import com.education.constitution.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    /*User findByEmail(String email);*/
    public boolean existsByUserName(String username);
    User findByUserName(String userName);
}