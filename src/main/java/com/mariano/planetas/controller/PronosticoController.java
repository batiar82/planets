package com.mariano.planetas.controller;

import com.mariano.planetas.modelo.Pronostico;
import com.mariano.planetas.service.PronosticoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class PronosticoController {

    private com.mariano.planetas.service.PronosticoService pronosticoService;

    public PronosticoController(PronosticoService pronosticoService) {
        this.pronosticoService = pronosticoService;
    }

    @GetMapping("/clima/{dia}")
    public ResponseEntity<Pronostico> getPronostico(@PathVariable("dia") Integer dia)
    {
        return ResponseEntity.ok(pronosticoService.getPronostico(dia));
    }
}
