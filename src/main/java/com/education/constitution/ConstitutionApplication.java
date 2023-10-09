package com.education.constitution;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
