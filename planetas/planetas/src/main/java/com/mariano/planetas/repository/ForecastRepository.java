package com.mariano.planetas.repository;

import com.mariano.planetas.model.Forecast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForecastRepository extends CrudRepository<Forecast, Integer> {

}
