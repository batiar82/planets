package com.mariano.planets.service;

import com.mariano.planets.model.Forecast;

public interface ForecastService {

    Integer countDryPeriods(Integer day);

    Integer countRainyPeriods(Integer day);

    Integer countOptimalPeriods(Integer day);

    Integer maxRainyDay();

    Forecast getForecast(Integer day);

}
