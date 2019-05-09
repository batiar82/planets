package com.mariano.planets.service.impl;

import com.mariano.planets.model.Forecast;
import com.mariano.planets.model.Planet;
import com.mariano.planets.model.Point;
import com.mariano.planets.utils.Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ForecastFactoryTest {
    private ForecastFactory forecastFactory = new ForecastFactory();

    @Test
    public void createDryTest()
    {
        int day = 0; //al momento 0 todos los planetas estan alineados
        Point vulcanoPosition = Utils.getPosition(Planet.VULCANO,0);
        Point ferengiPosition = Utils.getPosition(Planet.FERENGI, 0);
        Point betasoidePosition = Utils.getPosition(Planet.BETASOIDE, 0);
        assertEquals(Forecast.Condition.DRY, forecastFactory.createForecasts(0).get(0).getCondition());
    }
    @Test
    public void createRainyTest()
    {
        int day = 6; //al momento 0 todos los planetas estan alineados
        Point vulcanoPosition = Utils.getPosition(Planet.VULCANO,0);
        Point ferengiPosition = Utils.getPosition(Planet.FERENGI, 0);
        Point betasoidePosition = Utils.getPosition(Planet.BETASOIDE, 0);
        assertEquals(Forecast.Condition.DRY, forecastFactory.createForecasts(0).get(0).getCondition());
    }
}
