package com.mariano.planetas.service;

import com.mariano.planetas.modelo.Pronostico;

public interface PronosticoService {

    Integer contarDiasSecos(Integer dia);

    Integer contarDiasDeLluvia(Integer dia);

    Integer contarDiasOptimos(Integer dia);

    Integer diaMayorIntensidad();

    Pronostico getPronostico(Integer dia);

    Integer contarPeriodos(Pronostico.Condicion condicion);

}
