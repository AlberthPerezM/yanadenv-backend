package com.yanadenv.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.Apoderado;
import com.yanadenv.backend.models.entitys.Participante;

public interface IApoderadoDao extends CrudRepository<Apoderado, Integer> {
	 @Query("from Participante")
	 public List<Participante> findAllParticipantes();
	 
}
