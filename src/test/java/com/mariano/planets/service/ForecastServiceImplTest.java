package com.mariano.planets.service;

import com.mariano.planets.model.Forecast;
import com.mariano.planets.repository.ForecastRepository;
import com.mariano.planets.service.impl.ForecastServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
public class ForecastServiceImplTest {

    private ForecastService forecastService;

    @MockBean
    private ForecastRepository forecastRepository;


    @Before
    public void setup()
    {
        forecastService = new ForecastServiceImpl(forecastRepository);
    }

    @Test
    public void countDryPeriods() {
        Integer expectedDryPeriods = 256;

        when(forecastRepository.countByDayAndCondition(any(), any())).thenReturn(expectedDryPeriods);
        assertEquals(expectedDryPeriods, forecastService.countDryPeriods(22));
    }
    @Test
    public void countRainyPeriods() {
        Integer expectedRainyPeriods = 35;

        when(forecastRepository.countByDayAndCondition(any(), any())).thenReturn(expectedRainyPeriods);
        assertEquals(expectedRainyPeriods, forecastService.countRainyPeriods(22));
    }
    @Test
    public void countOptimalPeriods() {
        Integer expectedOptimalPeriods = 54;

        when(forecastRepository.countByDayAndCondition(any(), any())).thenReturn(expectedOptimalPeriods);
        assertEquals(expectedOptimalPeriods, forecastService.countOptimalPeriods(22));
    }

    public void maxRainyDay() {

    }

    @Test
    public void getForecast() {
        Forecast forecast = new Forecast(1, Forecast.Condition.RAINY, false);
        when(forecastRepository.findById(1)).thenReturn(Optional.of(forecast));
        assertEquals(forecast, forecastService.getForecast(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void getForecastNotExistent() {
        Forecast forecast = new Forecast(1, Forecast.Condition.RAINY, false);
        when(forecastRepository.findById(1)).thenReturn(Optional.of(forecast));
        assertEquals(forecast, forecastService.getForecast(2));
    }
}
