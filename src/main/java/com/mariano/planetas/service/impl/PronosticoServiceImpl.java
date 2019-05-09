package com.mariano.planetas.service.impl;

import com.mariano.planetas.modelo.Pronostico;
import com.mariano.planetas.repository.PronosticoRepository;
import com.mariano.planetas.service.PronosticoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PronosticoServiceImpl implements PronosticoService {

    private Map<Pronostico.Condicion, Integer> periodos;

    private PronosticoRepository pronosticoRepository;

    public PronosticoServiceImpl(PronosticoRepository pronosticoRepository, Map<Pronostico.Condicion, Integer> periodos) {
        this.pronosticoRepository = pronosticoRepository;
        this.periodos = periodos;
    }


    @Override
    public Integer contarDiasSecos(Integer dia) {
        return pronosticoRepository.countByCondicionAndDiaLessThan(Pronostico.Condicion.SEQUIA,dia);
    }

    @Override
    public Integer contarDiasDeLluvia(Integer dia) {
        return pronosticoRepository.countByCondicionAndDiaLessThan(Pronostico.Condicion.LLUVIA, dia);
    }

    @Override
    public Integer contarDiasOptimos(Integer dia) {
        return pronosticoRepository.countByCondicionAndDiaLessThan(Pronostico.Condicion.OPTIMA,dia);
    }

    @Override
    public Integer diaMayorIntensidad() {
        return pronosticoRepository.findFirstByCondicionOrderByIntensidadDesc(Pronostico.Condicion.LLUVIA).getDia();
    }

    @Override
    public Integer contarPeriodos(Pronostico.Condicion condicion)
    {
        return periodos.getOrDefault(condicion,0);
    }

    @Override
    public Pronostico getPronostico(Integer dia) {
        return pronosticoRepository.findById(dia).get();
    }
}
