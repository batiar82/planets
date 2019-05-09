package com.mariano.planetas.utils;


import com.mariano.planetas.modelo.Pronostico;
import com.mariano.planetas.repository.PronosticoRepository;
import com.mariano.planetas.service.PronosticoService;
import com.mariano.planetas.service.impl.PronosticoFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class EventListenerBean {

    private PronosticoRepository pronosticoRepository;

    private PronosticoFactory forecastFactory;

    @Autowired
    PronosticoService service;

    public EventListenerBean(PronosticoRepository pronosticoRepository, PronosticoFactory forecastFactory) {
        this.pronosticoRepository = pronosticoRepository;
        this.forecastFactory = forecastFactory;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<Pronostico> forecasts = forecastFactory.crearPronosticos(365*10);
        pronosticoRepository.saveAll(forecasts);

        log.debug("Pronostico seeded for the next 10 years");
    }
}