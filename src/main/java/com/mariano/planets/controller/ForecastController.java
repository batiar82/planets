package com.mariano.planets.controller;

import com.mariano.planets.model.Forecast;
import com.mariano.planets.service.ForecastService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ForecastController {

    private ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/clima/{day}")
    public ResponseEntity<Forecast> getForecast(@PathVariable("day") Integer day)
    {
        return ResponseEntity.ok(forecastService.getForecast(day));
    }
}
