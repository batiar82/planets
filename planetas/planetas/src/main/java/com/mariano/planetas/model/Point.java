package com.mariano.planetas.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Point {
    private double x;
    private double y;

    public Point round()
    {
        return new Point(
                BigDecimal.valueOf(x).setScale(5, RoundingMode.HALF_UP).doubleValue(),
                BigDecimal.valueOf(y).setScale(5, RoundingMode.HALF_UP).doubleValue()
        );
    }
}
