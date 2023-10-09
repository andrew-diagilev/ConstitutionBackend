package com.education.constitution.controller;

import com.education.constitution.model.DTO.CommonResponseDTO;
import com.education.constitution.service.AccessCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/registration")
public class UserAccessCodeController {
    private final AccessCodeService accessCodeService;


    public UserAccessCodeController(AccessCodeService accessCodeService) {
        this.accessCodeService = accessCodeService;
    }

    @PostMapping("access_code")
    public ResponseEntity<CommonResponseDTO> findAccessCode(@RequestBody Map<String, String> requestBody) {
        String code = requestBody.get("code");
        CommonResponseDTO responseDTO = accessCodeService.findByCode(code).isPresent()
                ? new CommonResponseDTO(true, "Код присутній: " + code)
                : new CommonResponseDTO(false, "Не існуючий код доступу: " + code);
        return ResponseEntity.ok(responseDTO);
    }
}

