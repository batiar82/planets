package com.mariano.planets.utils;


import com.mariano.planets.model.Forecast;
import com.mariano.planets.repository.ForecastRepository;
import com.mariano.planets.service.ForecastService;
import com.mariano.planets.service.impl.ForecastFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class EventListenerBean {

    private ForecastRepository forecastRepository;

    private ForecastFactory forecastFactory;

    @Autowired
    ForecastService service;

    public EventListenerBean(ForecastRepository forecastRepository, ForecastFactory forecastFactory) {
        this.forecastRepository = forecastRepository;
        this.forecastFactory = forecastFactory;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<Forecast> forecasts = forecastFactory.createForecasts(365*10);
        forecastRepository.saveAll(forecasts);

        log.debug("Forecast seeded for the next 10 years");
    }
}