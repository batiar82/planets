package com.mariano.planets.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Planet {
    public static final Planet FERENGI = new Planet(1, 500, true);
    public static final Planet BETASOIDE = new Planet(3, 200, true);
    public static final Planet VULCANO =  new Planet(5, 1000, false);

    /**
     * speed in degrees per day
     */
    private int speed;
    /**
     * distance in km
     */
    private int distance;
    /**
     * clockwise rotation
     */
    private boolean clockwise;

    public int getDegresAtDays(int day)
    {
        int deg = clockwise ? speed * day*-1 : speed * day;
        return deg % 360 ;
    }
}
