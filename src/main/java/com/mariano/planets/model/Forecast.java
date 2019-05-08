package com.mariano.planets.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    Double intensity;

    public enum Condition {
        RAINY, OPTIMAL, DRY,UNDETERMINED;
    }
}
