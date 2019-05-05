package com.mariano.planetas.utils;


import com.mariano.planetas.model.Forecast;
import com.mariano.planetas.repository.ForecastRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventListenerBean {

    private ForecastRepository forecastRepository;

    public EventListenerBean(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Forecast forecast;
        for (int i = 0; i< 365*10 ; i++)
        {
            forecast = new Forecast(i, Forecast.Condition.RAINY, false);
            forecastRepository.save(forecast);
        }
        log.debug("Forecast seeded for the next 10 years");

    }
}