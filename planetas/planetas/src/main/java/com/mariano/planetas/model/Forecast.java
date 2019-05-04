package com.mariano.planetas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
public class Forecast {
    @Id
    Integer day;

    String forecast;

    boolean maxRainDay;
}
