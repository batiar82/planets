package com.mariano.planetas.config;

import com.mariano.planetas.modelo.Pronostico;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PlanetasConfig {

    @Bean
    Map<Pronostico.Condicion, Integer> getPeriodos(){
        return new HashMap<>();
    }
}
