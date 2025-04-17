package com.yanadenv.backend.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.Participante;

public interface IParticipanteDao extends CrudRepository<Participante, Integer >{
  /*  List<Participante> findByExamenes(Integer idExa);*/
    List<Participante> findByExamenesLaboratorio_IdExa(Integer idExa);

}
