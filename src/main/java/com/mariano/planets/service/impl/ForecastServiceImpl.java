package com.mariano.planets.service.impl;

import com.mariano.planets.model.Forecast;
import com.mariano.planets.model.Planet;
import com.mariano.planets.model.Point;
import com.mariano.planets.repository.ForecastRepository;
import com.mariano.planets.service.ForecastService;
import com.mariano.planets.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class ForecastServiceImpl implements ForecastService {

    private ForecastRepository forecastRepository;

    public ForecastServiceImpl(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    @Override
    public Integer countDryPeriods(Integer day) {

        Integer dryPeriods = 0;

        for(int i = 0 ; i<day; i++)
        {
            if(Utils.areAlignedWithTheSun(day,Planet.VULCANO, Planet.FERENGI, Planet.BETASOIDE))
            {
                dryPeriods++;
            }
        }
        return dryPeriods;
    }

    @Override
    public Integer countRainyPeriods(Integer day) {

        Integer rainyPeriods = 0;
        for(int i = 0 ; i<day; i++)
        {
            Point vulcanoPosition = Utils.getPosition(Planet.VULCANO, i);
            Point ferengiPosition = Utils.getPosition(Planet.FERENGI, i);
            Point betasoidePosition = Utils.getPosition(Planet.BETASOIDE, i);
            if(Utils.rainyPeriod(vulcanoPosition, ferengiPosition,betasoidePosition))
            {
                rainyPeriods++;
            }
        }
        return rainyPeriods;
    }

    @Override
    public Integer countOptimalPeriods(Integer day) {
        Integer optimalPeriods = 0;
        for(int i = 0 ; i<day; i++)
        {
            Point vulcanoPosition = Utils.getPosition(Planet.VULCANO, i);
            Point ferengiPosition = Utils.getPosition(Planet.FERENGI, i);
            Point betasoidePosition = Utils.getPosition(Planet.BETASOIDE, i);
            if(Utils.optimalPeriod(vulcanoPosition, ferengiPosition,betasoidePosition))
            {
                optimalPeriods++;
            }
        }
        return optimalPeriods;
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
