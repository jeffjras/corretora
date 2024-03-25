package br.com.challenge.corretora.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static ObjectMapper objectMapper() { return new ObjectMapper(); }
}
