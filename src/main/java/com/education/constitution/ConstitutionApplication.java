package com.education.constitution;


import com.education.constitution.model.Role;
import com.education.constitution.service.TestResultMapper;
import com.education.constitution.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication

public class ConstitutionApplication {


   /* @Bean
    public TestResultMapper testResultMapper() {
        return Mappers.getMapper(TestResultMapper.class);
    }*/
    public static void main(String[] args) {
        SpringApplication.run(ConstitutionApplication.class, args);
    }

}
