package com.mariano.planetas.service.impl;

import com.mariano.planetas.modelo.Planeta;
import com.mariano.planetas.modelo.Pronostico;
import com.mariano.planetas.modelo.Punto;
import com.mariano.planetas.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mariano.planetas.utils.Utils.intensidad;

@Service
public class PronosticoFactory {

    public List<Pronostico> crearPronosticos(Integer dias)
    {
        List<Pronostico> forecasts = new ArrayList<>();

        for(int i = 0;i<= dias; i++)
        {
            Pronostico forecast = crearPronostico(i);
            forecasts.add(forecast);
        }
        return forecasts;
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
