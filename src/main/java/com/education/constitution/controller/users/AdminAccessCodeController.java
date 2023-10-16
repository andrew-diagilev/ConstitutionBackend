package com.education.constitution.controller.users;

import com.education.constitution.service.AccessCodeService;
import com.education.constitution.utils.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/admin/access_code")
public class AdminAccessCodeController {
    @Autowired
    AccessCodeService accessCodeService;

    @Autowired
    PdfGenerator pdfGenerator;

    @GetMapping("/create/{amount}")
    public ResponseEntity<byte[]> createAccessCodes(@PathVariable Integer amount) {
        try {
            byte[] pdfBytes = pdfGenerator.generatePdfWithKeys(accessCodeService.createAccessCodesList(amount));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "codes.pdf"); // Имя файла

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(pdfBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
