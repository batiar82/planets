package com.mariano.planetas.service.impl;

import com.mariano.planetas.modelo.Planeta;
import com.mariano.planetas.modelo.Pronostico;
import com.mariano.planetas.modelo.Punto;
import com.mariano.planetas.utils.Utils;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class PronosticoFactoryTest {

    private PronosticoFactory pronosticoFactory = new PronosticoFactory(new HashMap<>());

    @Test
    public void createDryTest()
    {
        int day = 0; //al momento 0 todos los planetas estan alineados
        Punto vulcanoPosition = Utils.getPosicion(Planeta.VULCANO,0);
        Punto ferengiPosition = Utils.getPosicion(Planeta.FERENGI, 0);
        Punto betasoidePosition = Utils.getPosicion(Planeta.BETASOIDE, 0);
        assertEquals(Pronostico.Condicion.SEQUIA, pronosticoFactory.crearPronosticos(0).get(0).getCondicion());
    }
}
