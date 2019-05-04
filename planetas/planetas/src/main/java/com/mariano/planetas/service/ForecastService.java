package com.mariano.planetas.service;

import com.mariano.planetas.model.Forecast;

public interface ForecastService {

    Integer countDryPeriods(Integer day);

    Integer countRainyPeriods(Integer day);

    Integer countOptimallPeriods(Integer day);

    Integer maxRainyDay();

    Forecast getForecast(Integer day);

}
