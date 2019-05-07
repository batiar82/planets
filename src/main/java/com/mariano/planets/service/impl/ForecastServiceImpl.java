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
        return forecastRepository.countByConditionAndDayLessThan(Forecast.Condition.DRY,day);
    }

    @Override
    public Integer countRainyPeriods(Integer day) {
        return forecastRepository.countByConditionAndDayLessThan(Forecast.Condition.RAINY, day);
    }

    @Override
    public Integer countOptimalPeriods(Integer day) {
        return forecastRepository.countByConditionAndDayLessThan(Forecast.Condition.OPTIMAL,day);
    }

    @Override
    public Integer maxRainyDay() {
        return forecastRepository.findFirstByConditionOrderByIntensityDesc(Forecast.Condition.RAINY).getDay();
    }

    @Override
    public Forecast getForecast(Integer day) {
        return forecastRepository.findById(day).get();
    }
}
