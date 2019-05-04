package com.mariano.planetas.service.impl;

import com.mariano.planetas.model.Forecast;
import com.mariano.planetas.repository.ForecastRepository;
import com.mariano.planetas.service.ForecastService;
import org.springframework.stereotype.Service;

@Service
public class ForecastServiceImpl implements ForecastService {

    private ForecastRepository forecastRepository;

    public ForecastServiceImpl(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    @Override
    public Integer countDryPeriods(Integer day) {
        return null;
    }

    @Override
    public Integer countRainyPeriods(Integer day) {
        return null;
    }

    @Override
    public Integer countOptimalPeriods(Integer day) {
        return forecastRepository.countByForecast()
    }

    @Override
    public Integer maxRainyDay() {
        return forecastRepository.findByMaxRainDay();
    }

    @Override
    public Forecast getForecast(Integer day) {
        return forecastRepository.findById(day).get();
    }
}
