package com.education.constitution.service;

import com.education.constitution.model.Role;
import com.education.constitution.model.User;
import com.education.constitution.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends AbstractService<User, Long, UserRepository> {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository) {
        super(repository);
    }

    public String createUser(String username, String name, String password, List<Role> roles, String email) {
        boolean userExists = repository.existsByUserName(username);
        if (!userExists) {
            User newUser = repository.save(new User(username, name, passwordEncoder.encode(password), roles, email));
            return new String("Користувача " + newUser.getUserName() + " " + " успішно створено");
        } else return new String("Помилка. Користувач вже існує");
    }
    public User findByUserName(String name) {
       return repository.findByUserName(name);
    }
}
