package com.education.constitution.service;

import com.education.constitution.exception.NotFoundException;
import com.education.constitution.model.users.Role;
import com.education.constitution.model.users.User;
import com.education.constitution.repository.users.AccessCodeRepository;
import com.education.constitution.repository.users.RoleRepository;
import com.education.constitution.repository.users.UserRepository;
import com.education.constitution.utils.MailService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends AbstractService<User, Long, UserRepository> {

    private final String ROLE = "ROLE_USER";
    private final BCryptPasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private AccessCodeRepository accessCodeRepository;
    private MailService mailService;

    public UserService(UserRepository repository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository, AccessCodeRepository accessCodeRepository, MailService mailService) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.accessCodeRepository = accessCodeRepository;
        this.mailService = mailService;
    }

    public String createUser(String username, String name, String password, List<Role> roles, String email) {
        boolean userExists = repository.existsByUserName(username);
        if (!userExists) {
            User newUser = repository.save(new User(username, name, passwordEncoder.encode(password), roles, email));
            return new String("Користувача " + newUser.getUserName() + " " + " успішно створено");
        } else return new String("Помилка. Користувач вже існує");
    }


    public User createUserFromApp(User user, String accessCode){
        List<Role> roleList = new ArrayList<>();
        roleRepository.findByRole(ROLE);
        roleList.add(roleRepository.findByRole(ROLE));
        user.setRoles(roleList);
        user.setAccessCode(accessCodeRepository.findByCode(accessCode).get());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User findByUserName(String name) {
       return repository.findByUserName(name);
    }
   public User verifyUser(Long id, String accessCode, String email){
        User user = repository.findByIdAndAccessCodeCodeAndEmail(id, accessCode, email).orElseThrow(() -> new NotFoundException("Під час верифікації користувача виникла помилка"));
        user.setVerified(true);
        return repository.save(user);
   }
}
