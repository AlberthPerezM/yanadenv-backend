
package com.yanadenv.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.Centro;
import com.yanadenv.backend.models.entitys.Nivel;

public interface ICentroDao extends CrudRepository<Centro,Integer>{

    @Query("from Nivel")
    public List<Nivel> findAllNiveles();
}
