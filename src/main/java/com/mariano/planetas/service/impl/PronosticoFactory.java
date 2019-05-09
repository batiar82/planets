package com.mariano.planetas.service.impl;

import com.mariano.planetas.modelo.Planeta;
import com.mariano.planetas.modelo.Pronostico;
import com.mariano.planetas.modelo.Punto;
import com.mariano.planetas.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mariano.planetas.utils.Utils.intensidad;

@Service
public class PronosticoFactory {

    @Autowired
    private Map<Pronostico.Condicion, Integer> periodos;

    public List<Pronostico> crearPronosticos(Integer dias)
    {
        List<Pronostico> pronosticos = new ArrayList<>();
        Pronostico.Condicion condicionPrevia = Pronostico.Condicion.ERRONEO;

        for(int i = 0;i<= dias; i++)
        {

            Pronostico pronostico = crearPronostico(i);
            pronosticos.add(pronostico);

            if(!condicionPrevia.equals(pronostico.getCondicion()))
            {
                periodos.merge(pronostico.getCondicion(), 1, (v1,v2)-> v1 + v2);
                condicionPrevia = pronostico.getCondicion();
            }
        }
        return pronosticos;
    }

    protected Pronostico crearPronostico(Integer dia)
    {
        Punto vulcanoPosicion = Utils.getPosicion(Planeta.VULCANO,dia);
        Punto ferengiPosicion = Utils.getPosicion(Planeta.FERENGI, dia);
        Punto betasoidePosicion = Utils.getPosicion(Planeta.BETASOIDE, dia);

        Pronostico.Condicion condicion= Pronostico.Condicion.ERRONEO;

        if(Utils.periodoDeLluvia(vulcanoPosicion, ferengiPosicion, betasoidePosicion))
        {
            condicion = Pronostico.Condicion.LLUVIA;
        }
        if(Utils.periodoOptimo(vulcanoPosicion, ferengiPosicion, betasoidePosicion))
        {
            condicion = Pronostico.Condicion.OPTIMA;
        }
        if(Utils.periodoSeco(vulcanoPosicion, ferengiPosicion, betasoidePosicion))
        {
            condicion = Pronostico.Condicion.SEQUIA;
        }
        return new Pronostico(dia, condicion, intensidad(vulcanoPosicion, ferengiPosicion, betasoidePosicion) );
    }
}
