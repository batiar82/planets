package com.mariano.planets.repository;

import com.mariano.planets.model.Forecast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForecastRepository extends CrudRepository<Forecast, Integer> {

    Integer countByDayAndCondition(Integer day, Forecast.Condition condition);
}
