package com.mariano.planetas.model;

import com.mariano.planetas.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
public class Planet {
    public static final Planet FERENGI = new Planet(1, 500, true);
    public static final Planet BETASOIDE = new Planet(3, 200, true);
    public static final Planet VULCANO =  new Planet(5, 1000, true);

    /**
     * speed in degress per day
     */
    private int speed;
    /**
     * distance in km
     */
    private int distance;
    /**
     * clockwise is true
     */
    private boolean clockwise;

    public int getDegressAtDays(int day)
    {
        int deg = clockwise ? speed * day*-1 : speed * day;
        return deg % 360 ;
    }
}
