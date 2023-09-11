package com.education.constitution;


import com.education.constitution.service.TestResultMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
