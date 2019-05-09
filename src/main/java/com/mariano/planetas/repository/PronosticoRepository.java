package com.mariano.planetas.repository;

import com.mariano.planetas.modelo.Pronostico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PronosticoRepository extends CrudRepository<Pronostico, Integer> {

    Integer countByCondicionAndDiaLessThan(Pronostico.Condicion condicion, Integer dia);

    Pronostico findFirstByCondicionOrderByIntensidadDesc(Pronostico.Condicion condicion);
}
