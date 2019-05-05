package com.mariano.planetas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Forecast {
    @Id
    Integer day;

    Condition condition;

    boolean maxRainDay;

    public enum Condition {
        RAINY, OPTIMAL, DRY;
    }
}
