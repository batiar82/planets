package com.mariano.planetas.service.impl;

import com.mariano.planetas.modelo.Pronostico;
import com.mariano.planetas.repository.PronosticoRepository;
import com.mariano.planetas.service.PronosticoService;
import org.springframework.stereotype.Service;

@Service
public class PronosticoServiceImpl implements PronosticoService {

    private PronosticoRepository pronosticoRepository;


    public PronosticoServiceImpl(PronosticoRepository pronosticoRepository) {
        this.pronosticoRepository = pronosticoRepository;
    }

    @Override
    public Integer contarPeriodosSecos(Integer dia) {
        return pronosticoRepository.countByCondicionAndDiaLessThan(Pronostico.Condicion.SEQUIA,dia);
    }

    @Override
    public Integer contarPeriodosDeLluvia(Integer dia) {
        return pronosticoRepository.countByCondicionAndDiaLessThan(Pronostico.Condicion.LLUVIA, dia);
    }

    @Override
    public Integer contarPeriodosOptimos(Integer dia) {
        return pronosticoRepository.countByCondicionAndDiaLessThan(Pronostico.Condicion.OPTIMA,dia);
    }

    @Override
    public Integer diaMayorIntensidad() {
        return pronosticoRepository.findFirstByCondicionOrderByIntensidadDesc(Pronostico.Condicion.LLUVIA).getDia();
    }

    @Override
    public Pronostico getPronostico(Integer dia) {
        return pronosticoRepository.findById(dia).get();
    }
}
