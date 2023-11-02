package com.education.constitution.controller.users;

import com.education.constitution.exception.AccessTokenNotfoundException;
import com.education.constitution.exception.AccessTokenTakenException;
import com.education.constitution.exception.UserRegistrationException;
import com.education.constitution.model.DTO.CommonResponseDTO;
import com.education.constitution.service.AccessCodeService;
import com.education.constitution.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/registration")
public class UserAccessCodeController {
    private final AccessCodeService accessCodeService;
    private final UserService userService;

    public UserAccessCodeController(AccessCodeService accessCodeService, UserService userService) {
        this.accessCodeService = accessCodeService;
        this.userService = userService;
    }

    @PostMapping("access_code")
    public ResponseEntity<?> findAccessCode(@RequestBody Map<String, String> requestBody) {
        String accessCode = requestBody.get("code");
        accessCodeService.findByCode(accessCode).orElseThrow(() -> new AccessTokenNotfoundException("Неіснуючий код доступу введіть правильний код"));
        if (userService.getByAccessCode(accessCode).isPresent()) {
            throw new AccessTokenTakenException( "Код доступу вже використовується");
        }
        return ResponseEntity.ok(accessCode);
    }
}

