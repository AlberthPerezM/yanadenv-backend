package com.yanadenv.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.Distrito;
import com.yanadenv.backend.models.entitys.Provincia;

public interface IProvinciaDao extends CrudRepository<Provincia,Integer>{
	 @Query("from Distrito")
	 public List<Distrito> findAllDistritos();
}
