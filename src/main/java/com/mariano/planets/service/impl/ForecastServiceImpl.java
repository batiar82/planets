package com.mariano.planets.service.impl;

import com.mariano.planets.model.Forecast;
import com.mariano.planets.repository.ForecastRepository;
import com.mariano.planets.service.ForecastService;
import org.springframework.stereotype.Service;

@Service
public class ForecastServiceImpl implements ForecastService {

    private ForecastRepository forecastRepository;


    public ForecastServiceImpl(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    @Override
    public Integer countDryPeriods(Integer day) {
        return forecastRepository.countByDayAndCondition(day, Forecast.Condition.DRY);
    }

    @Override
    public Integer countRainyPeriods(Integer day) {
        return forecastRepository.countByDayAndCondition(day, Forecast.Condition.RAINY);
    }

    @Override
    public Integer countOptimalPeriods(Integer day) {
        return forecastRepository.countByDayAndCondition(day, Forecast.Condition.OPTIMAL);
    }

    @Override
    public Integer maxRainyDay() {
        return 1;//return forecastRepository.findByMaxRainDay();
    }

    @Override
    public Forecast getForecast(Integer day) {
        return forecastRepository.findById(day).get();
    }
}
