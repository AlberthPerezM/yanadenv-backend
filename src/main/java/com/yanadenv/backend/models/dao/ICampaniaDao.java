package com.yanadenv.backend.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.Campania;

public interface ICampaniaDao extends CrudRepository<Campania, Integer> {
    // Listarn por centro
    List<Campania> findByCentro_IdCent(Integer idCentro);

}
