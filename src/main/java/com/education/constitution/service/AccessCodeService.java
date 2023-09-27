package com.education.constitution.service;

import com.education.constitution.model.AccessCode;
import com.education.constitution.repository.AccessCodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AccessCodeService extends AbstractService<AccessCode, Long, AccessCodeRepository> {

    private static final String NUMERIC_CHARS = "0123456789";
    private static final String ALPHABETIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int GROUP_SIZE = 4;
    private static final int NUM_GROUPS = 3;
    private static final int KEY_LENGTH = GROUP_SIZE * NUM_GROUPS;
    private final Random random = new SecureRandom();

    public AccessCodeService(AccessCodeRepository repository) {
        super(repository);
    }

    @Transactional
    public List<AccessCode> createAccessCodesList(int amount) {
        List<AccessCode> savedCodes = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            AccessCode accessCode = new AccessCode();
            accessCode.setCode(generateUniqueKey());
            savedCodes.add(accessCode);
        }
        return addSeparator(repository.saveAll(savedCodes));
    }

    private String generateUniqueKey() {
        StringBuilder key = new StringBuilder(KEY_LENGTH);

        for (int group = 0; group < NUM_GROUPS; group++) {
            String charset = (group % 2 == 0) ? NUMERIC_CHARS : ALPHABETIC_CHARS;

            for (int i = 0; i < GROUP_SIZE; i++) {
                key.append(charset.charAt(random.nextInt(charset.length())));
            }
        }
        return key.toString();
    }

    private List<AccessCode> addSeparator(List<AccessCode> accessCodes) {
        List<AccessCode> updatedAccessCodes = new ArrayList<>();
        for (AccessCode accessCode : accessCodes) {
            String codeString = accessCode.getCode();
            String formattedCode = codeString.substring(0, 4) + "-" +
                    codeString.substring(4, 8) + "-" +
                    codeString.substring(8, 12);

            // Создать новый объект AccessCode с отформатированным кодом
            AccessCode updatedAccessCode = new AccessCode();
            updatedAccessCode.setCode(formattedCode);
            updatedAccessCodes.add(updatedAccessCode);
        }
        return updatedAccessCodes;
    }

}