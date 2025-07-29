package com.yanadenv.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.Centro;
import com.yanadenv.backend.models.entitys.Distrito;

public interface IDistritoDao extends CrudRepository<Distrito,Integer>{
    @Query("from Centro")
    public List<Centro> findAllCentros();
}
