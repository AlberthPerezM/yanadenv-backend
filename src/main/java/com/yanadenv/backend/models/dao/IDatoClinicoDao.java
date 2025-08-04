package com.yanadenv.backend.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.DatoClinico;

public interface IDatoClinicoDao extends CrudRepository<DatoClinico, Integer> {
    List<DatoClinico> findByParticipanteIdPar(Integer idPar);

}
