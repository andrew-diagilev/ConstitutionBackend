package com.education.constitution.config;

import com.education.constitution.model.DTO.UserRegistrationDTO;
import com.education.constitution.model.users.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(UserRegistrationDTO.class, User.class)
                .addMapping(UserRegistrationDTO::getUserName, User::setEmail);
        return modelMapper;
    }
}