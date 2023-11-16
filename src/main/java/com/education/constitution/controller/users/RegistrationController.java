package com.education.constitution.controller.users;

import com.education.constitution.model.DTO.UserRegistrationDTO;
import com.education.constitution.model.users.User;
import com.education.constitution.service.UserService;
import com.education.constitution.utils.MailService;
import jakarta.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    @Value("${email.template.body}")
    private String bodyTemplate;

    @Value("${email.template.subject}")
    private String subjectTemplate;

    @Value("${email.template.link}")
    private String linkTemplate;

    private final UserService userService;

    private final ModelMapper modelMapper;

    private final MailService mailService;

    public RegistrationController(UserService userService, ModelMapper modelMapper, MailService mailService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.mailService = mailService;
    }

    @PostMapping("register_user")
    @ResponseBody
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        System.out.println(bodyTemplate);
        try {
            User user = modelMapper.map(userRegistrationDTO, User.class);
            User registeredUser = userService.createUserFromApp(user, userRegistrationDTO.getAccessCode());
            try {
                mailService.sendEmail(registeredUser.getEmail(), subjectTemplate, String.format(bodyTemplate, registeredUser.getName(), registeredUser.getName(), registeredUser.getUserName(), String.format(linkTemplate, registeredUser.getId(), registeredUser.getAccessCode().getCode(), registeredUser.getEmail())));
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed: " + e.getMessage());
        }
    }

    @GetMapping("/verify_user")
    public ModelAndView verifyUser(@RequestParam Long id, @RequestParam String accessCode, @RequestParam String email) {
        User user = userService.verifyUser(id, accessCode, email);
        ModelAndView modelAndView = new ModelAndView("verification");
        modelAndView.addObject("userName", user.getUserName());
        return modelAndView;
    }

}
