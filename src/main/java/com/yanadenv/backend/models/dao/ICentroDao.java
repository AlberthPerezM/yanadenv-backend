
package com.yanadenv.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.Campania;
import com.yanadenv.backend.models.entitys.Centro;

public interface ICentroDao extends CrudRepository<Centro, Integer> {

    @Query("from Campania")
    public List<Campania> findAllCampanias();
}
