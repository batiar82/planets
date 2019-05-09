package com.mariano.planetas.modelo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Punto {
    private double x;
    private double y;

    public Punto redondear()
    {
        return new Punto(
                BigDecimal.valueOf(x).setScale(5, RoundingMode.HALF_UP).doubleValue(),
                BigDecimal.valueOf(y).setScale(5, RoundingMode.HALF_UP).doubleValue()
        );
    }
}
