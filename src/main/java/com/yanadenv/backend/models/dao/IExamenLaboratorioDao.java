package com.yanadenv.backend.models.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.ExamenLaboratorio;
import com.yanadenv.backend.models.entitys.Participante;

public interface IExamenLaboratorioDao extends CrudRepository<ExamenLaboratorio, Integer>{
    /*Consulta JPQL*/
    @Query("SELECT p FROM Participante p JOIN p.examenesLaboratorio e WHERE e.idExa = :idExa")
    List<Participante> findParticipantesByExamenId(Integer idExa);
    /*Busqueda automática*/
    List<ExamenLaboratorio> findByParticipantes_IdPar(Integer idPar);


}
