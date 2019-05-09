package com.mariano.planetas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Planeta {
    public static final Planeta FERENGI = new Planeta(1, 500, true);
    public static final Planeta BETASOIDE = new Planeta(3, 200, true);
    public static final Planeta VULCANO =  new Planeta(5, 1000, false);

    /**
     * speed in degrees per day
     */
    private int velocidad;
    /**
     * distancia in km
     */
    private int distancia;
    /**
     * clockwise rotation
     */
    private boolean sentido;

    public int getGradosParaElDia(int dia)
    {
        int gradros = sentido ? velocidad * dia*-1 : velocidad * dia;
        return gradros % 360 ;
    }
}
