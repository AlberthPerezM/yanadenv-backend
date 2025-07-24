package com.yanadenv.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.Provincia;
import com.yanadenv.backend.models.entitys.Region;

public interface IRegionDao extends CrudRepository<Region,Integer>{
	 @Query("from Provincia")
	 public List<Provincia> findAllProvincias();
}
