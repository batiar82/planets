package com.mariano.planetas.controller;

import com.mariano.planetas.model.Forecast;
import com.mariano.planetas.service.ForecastService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
