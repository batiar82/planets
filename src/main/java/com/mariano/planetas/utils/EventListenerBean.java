package com.mariano.planetas.utils;


import com.mariano.planetas.modelo.Pronostico;
import com.mariano.planetas.repository.PronosticoRepository;
import com.mariano.planetas.service.PronosticoService;
import com.mariano.planetas.service.impl.PronosticoFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class EventListenerBean {

    private PronosticoRepository pronosticoRepository;

    private PronosticoFactory forecastFactory;
    private static final int DIEZ_AÑOS = 365*10;
    @Autowired
    PronosticoService service;

    public EventListenerBean(PronosticoRepository pronosticoRepository, PronosticoFactory forecastFactory) {
        this.pronosticoRepository = pronosticoRepository;
        this.forecastFactory = forecastFactory;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<Pronostico> forecasts = forecastFactory.crearPronosticos(DIEZ_AÑOS);
        pronosticoRepository.saveAll(forecasts);

        log.debug("Pronostico generado para los proximos 10 años");

        log.info(String.format("Cantidad de dias de lluvis: %s",service.contarDiasDeLluvia(DIEZ_AÑOS)));
        log.info(String.format("Cantidad de dias de sequia: %s",service.contarDiasSecos(DIEZ_AÑOS)));
        log.info(String.format("Cantidad de dias de optimos: %s",service.contarDiasOptimos(DIEZ_AÑOS)));
        log.info(String.format("Dia de mayor intensidad: %s",service.diaMayorIntensidad()));
        log.info(String.format("Cantidad de periodos de lluvis: %s",service.contarPeriodos(Pronostico.Condicion.LLUVIA)));
        log.info(String.format("Cantidad de periodos de sequia: %s",service.contarPeriodos(Pronostico.Condicion.SEQUIA)));
        log.info(String.format("Cantidad de periodos de optimos: %s",service.contarPeriodos(Pronostico.Condicion.OPTIMA)));


    }
}