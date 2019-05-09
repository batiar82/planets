package com.mariano.planets.service.impl;

import com.mariano.planets.model.Forecast;
import com.mariano.planets.model.Planet;
import com.mariano.planets.model.Point;
import com.mariano.planets.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mariano.planets.utils.Utils.intensity;

@Service
public class ForecastFactory {

    public List<Forecast> createForecasts(Integer days)
    {
        List<Forecast> forecasts = new ArrayList<>();

        for(int i = 0;i<= days; i++)
        {
            Forecast forecast = createForecast(i);
            forecasts.add(forecast);
        }
        return forecasts;
    }

    protected Forecast createForecast(Integer day)
    {
        Point vulcanoPosition = Utils.getPosition(Planet.VULCANO,day);
        Point ferengiPosition = Utils.getPosition(Planet.FERENGI, day);
        Point betasoidePosition = Utils.getPosition(Planet.BETASOIDE, day);

        Forecast.Condition condition= Forecast.Condition.UNDETERMINED;

        if(Utils.rainyPeriod(vulcanoPosition, ferengiPosition, betasoidePosition))
        {
            condition = Forecast.Condition.RAINY;
        }
        if(Utils.optimalPeriod(vulcanoPosition, ferengiPosition, betasoidePosition))
        {
            condition = Forecast.Condition.OPTIMAL;
        }
        if(Utils.dryPeriod(vulcanoPosition, ferengiPosition, betasoidePosition))
        {
            condition = Forecast.Condition.DRY;
        }
        return new Forecast(day, condition, intensity(vulcanoPosition, ferengiPosition, betasoidePosition) );
    }
}
