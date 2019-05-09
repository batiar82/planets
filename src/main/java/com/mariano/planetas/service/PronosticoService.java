package com.mariano.planetas.service;

import com.mariano.planetas.modelo.Pronostico;

public interface PronosticoService {

    Integer contarPeriodosSecos(Integer dia);

    Integer contarPeriodosDeLluvia(Integer dia);

    Integer contarPeriodosOptimos(Integer dia);

    Integer diaMayorIntensidad();

    Pronostico getPronostico(Integer dia);

}
