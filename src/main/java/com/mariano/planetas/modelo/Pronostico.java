package com.mariano.planetas.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pronostico {
    @Id
    Integer dia;

    Condicion condicion;

    @JsonIgnore
    Double intensidad;

    public enum Condicion {
        LLUVIA, OPTIMA, SEQUIA, ERRONEO
    }
}